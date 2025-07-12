package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantUserService {
    private final RestaurantService restaurantService;
    private final UserService userService;

    public List<User> getUsersByRestaurantId(UUID id) {
        var restaurant = restaurantService.findById(id);
        return restaurant.getUsers();
    }

    @Transactional
    public void addUser(UUID restaurantId, UUID userId) {
        var restaurant = restaurantService.findById(restaurantId);
        var user = userService.findById(userId);
        restaurant.addUser(user);
    }

    @Transactional
    public void removeUser(UUID restaurantId, UUID userId) {
        var restaurant = restaurantService.findById(restaurantId);
        var user = userService.findById(userId);
        restaurant.removeUser(user);
    }
}
