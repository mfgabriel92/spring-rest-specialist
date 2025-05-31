package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantPaymentMethodService {
    private final RestaurantService restaurantService;
    private final PaymentMethodService paymentMethodService;

    public Set<PaymentMethod> getPaymentMethodsByRestaurantId(UUID id) {
        var restaurant = restaurantService.findById(id);
        return restaurant.getPaymentMethods();
    }

    @Transactional
    public void addPaymentMethod(UUID restaurantId, UUID paymentMethodId) {
        var restaurant = restaurantService.findById(restaurantId);
        var paymentMethod = paymentMethodService.findById(paymentMethodId);
        restaurant.addPaymentMethod(paymentMethod);
    }

    @Transactional
    public void removePaymentMethod(UUID restaurantId, UUID paymentMethodId) {
        var restaurant = restaurantService.findById(restaurantId);
        var paymentMethod = paymentMethodService.findById(paymentMethodId);
        var restaurantHasPaymentMethod = restaurant.getPaymentMethods().stream().anyMatch(pm -> pm.getId().equals(paymentMethodId));

        if (!restaurantHasPaymentMethod) {
            throw new EntityNotFoundException(String.format("Payment method '%s' not found", paymentMethodId));
        }

        restaurant.removePaymentMethod(paymentMethod);
    }
}
