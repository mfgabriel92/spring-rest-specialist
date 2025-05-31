package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Order;
import com.gabriel.springrestspecialist.domain.repository.RestaurantOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantOrderService {
    private final RestaurantOrderRepository restaurantOrderRepository;
    private final RestaurantService restaurantService;

    public Order findById(UUID id) {
        return restaurantOrderRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Order '%s' not found", id)));
    }

    public List<Order> findAllByRestaurantId(UUID restaurantId) {
        var restaurant = restaurantService.findById(restaurantId);
        return restaurantOrderRepository.findAllByRestaurantId(restaurant.getId());
    }

    public Order findByRestaurantIdAndId(UUID restaurantId, UUID orderId) {
        var restaurant = restaurantService.findById(restaurantId);
        var order = findById(orderId);
        return restaurantOrderRepository.findByRestaurantIdAndId(restaurant.getId(), order.getId());
    }
}
