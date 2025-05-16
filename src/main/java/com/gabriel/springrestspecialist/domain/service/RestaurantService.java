package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Restaurant;
import com.gabriel.springrestspecialist.domain.repository.CuisineRepository;
import com.gabriel.springrestspecialist.domain.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final CuisineRepository cuisineRepository;

    public Restaurant save(Restaurant restaurant) {
        var cuisineId = restaurant.getCuisine().getId();
        var cuisine = cuisineRepository.findById(cuisineId).orElseThrow(() ->
            new EntityNotFoundException(String.format("Cuisine with id %s not found", cuisineId)));

        restaurant.setCuisine(cuisine);
        return restaurantRepository.save(restaurant);
    }
}
