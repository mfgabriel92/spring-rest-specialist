package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.exception.EntityAlreadyInUseException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Address;
import com.gabriel.springrestspecialist.domain.model.City;
import com.gabriel.springrestspecialist.domain.model.Cuisine;
import com.gabriel.springrestspecialist.domain.model.Restaurant;
import com.gabriel.springrestspecialist.domain.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final CuisineService cuisineService;
    private final CityService cityService;
    private final PaymentMethodService paymentMethodService;

    public Restaurant findById(UUID id) {
        return restaurantRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Restaurant '%s' not found", id)));
    }

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        var cuisineId = restaurant.getCuisine().getId();
        Cuisine cuisine;

        try {
            cuisine = cuisineService.findById(cuisineId);
        } catch (EntityNotFoundException e) {
            throw new BusinessLogicException(e.getMessage());
        }

        restaurant.setCuisine(cuisine);
        return restaurantRepository.saveAndFlush(restaurant);
    }

    @Transactional
    public void activate(UUID id) {
        var restaurant = findById(id);
        restaurant.activate();
        restaurantRepository.save(restaurant);
    }

    @Transactional
    public void deactivate(UUID id) {
        findById(id).deactivate();
    }

    @Transactional
    public Restaurant saveAddress(UUID id, Address request) {
        var restaurant = findById(id);
        City city;

        try {
            city = cityService.findById(request.getCity().getId());
        } catch (EntityNotFoundException e) {
            throw new BusinessLogicException(e.getMessage());
        }

        restaurant.setAddress(request);
        restaurant.getAddress().setCity(city);

        return restaurantRepository.saveAndFlush(restaurant);
    }

    @Transactional
    public void open(UUID id) {
        findById(id).open();
    }

    @Transactional
    public void close(UUID id) {
        findById(id).close();
    }

    @Transactional
    public void deleteById(UUID id) {
        var cuisine = findById(id);
        try {
            restaurantRepository.deleteById(cuisine.getId());
            restaurantRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyInUseException("Cannot delete restaurant because it is being used by another entity");
        }
    }
}
