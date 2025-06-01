package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.model.Order;
import com.gabriel.springrestspecialist.domain.model.OrderItem;
import com.gabriel.springrestspecialist.domain.model.OrderStatus;
import com.gabriel.springrestspecialist.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantService restaurantService;
    private final PaymentMethodService paymentMethodService;
    private final UserService userService;
    private final ProductService productService;

    public Order findById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() ->
            new BusinessLogicException(String.format("Order '%s' not found", id)));
    }

    @Transactional
    public Order save(Order order) {
        var restaurantId = order.getRestaurant().getId();
        var paymentMethodId = order.getPaymentMethod().getId();
        var userId = order.getUser().getId();

        var restaurant = restaurantService.findById(restaurantId);
        var paymentMethod = paymentMethodService.findById(paymentMethodId);
        var user = userService.findById(userId);

        order.setDeliveryFee(restaurant.getDeliveryFee());
        order.setPaymentMethod(paymentMethod);
        order.setUser(user);

        if (restaurant.doesNotAcceptPaymentMethod(paymentMethod)) {
            throw new BusinessLogicException("This restaurant does not accept this payment method");
        }

        for (OrderItem item : order.getItems()) {
            var product = productService.findById(item.getProduct().getId());
            item.setOrder(order);
            item.setProduct(product);
            item.setUnitPrice(product.getPrice());
        }

        order.calculateGrandTotal();
        return orderRepository.save(order);
    }

    @Transactional
    public void changeStatus(UUID id, OrderStatus status) {
        var order = findById(id);

        if (order.getStatus().cannotAlterToStatus(status)) {
            throw new BusinessLogicException(String.format(
                "Order '%s' cannot be altered to %s",
                order.getId(),
                status.getName()
            ));
        }

        order.setStatus(status);
    }
}
