package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.ApiException;
import com.gabriel.springrestspecialist.domain.exception.EntityAlreadyInUseException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Cuisine;
import com.gabriel.springrestspecialist.domain.model.Restaurant;
import com.gabriel.springrestspecialist.domain.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final CuisineService cuisineService;

    public Restaurant findById(UUID id) {
        return restaurantRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Restaurant with id %s not found", id)));
    }

    public Restaurant save(Restaurant restaurant) {
        var cuisineId = restaurant.getCuisine().getId();
        Cuisine cuisine;

        try {
            cuisine = cuisineService.findById(cuisineId);
        } catch (EntityNotFoundException e) {
            throw new ApiException(String.format("Cuisine with id %s not found", cuisineId));
        }

        restaurant.setCuisine(cuisine);
        return restaurantRepository.save(restaurant);
    }

    public void deleteById(UUID id) {
        var cuisine = findById(id);
        try {
            restaurantRepository.deleteById(cuisine.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyInUseException(String.format("Cannot delete restaurant %s because it is being used by another entity", id));
        }
    }
}
