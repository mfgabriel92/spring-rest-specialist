package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Restaurant;
import com.gabriel.springrestspecialist.domain.repository.RestaurantRepository;
import com.gabriel.springrestspecialist.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> findAll() {
        return ok(restaurantRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurant> findBId(@PathVariable UUID id) {
        var restaurant = restaurantRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Restaurant with id %s not found", id)));

        return ok(restaurant);
    }

    @GetMapping("containing")
    public ResponseEntity<List<Restaurant>> findByNameContaining(String name) {
        return ok(restaurantRepository.findByNameContaining(name));
    }

    @GetMapping("free-delivery")
    public ResponseEntity<List<Restaurant>> findAllFreeDelivery() {
        return ok(restaurantRepository.findAllFreeDelivery());
    }

    @GetMapping("no-kitchen")
    public ResponseEntity<List<Restaurant>> findAllWithoutKitchen() {
        return ok(restaurantRepository.findAllWithoutKitchen());
    }

    @GetMapping("name-with-delivery-fee")
    public ResponseEntity<List<Restaurant>> findAllByNameAndDeliveryFee(String name, BigDecimal deliveryFee) {
        return ok(restaurantRepository.findAllByNameAndDeliveryFee(name, deliveryFee));
    }

    @GetMapping("delivery-fees-between")
    public ResponseEntity<List<Restaurant>> findAllByNameLikeAndBetweenDeliveryFees(String name, BigDecimal minDeliveryFee, BigDecimal maxDeliveryFee) {
        return ok(restaurantRepository.findAllByNameLikeAndBetweenDeliveryFees(name, minDeliveryFee, maxDeliveryFee));
    }

    @GetMapping("latest")
    public ResponseEntity<Optional<Restaurant>> findLatestRegistered() {
        var latest = restaurantRepository.findLatestRegistered();
        return latest.isPresent()
            ? ok(latest)
            : ok(Optional.empty());
    }

    @GetMapping("first")
    public ResponseEntity<Optional<Restaurant>> findFirstRegistered() {
        var latest = restaurantRepository.findFirstRegistered();
        return latest.isPresent()
            ? ok(latest)
            : ok(Optional.empty());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Restaurant restaurant) {
        try {
            restaurant = restaurantService.save(restaurant);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> save(@PathVariable UUID id, @RequestBody Restaurant restaurant) {
        try {
            var current = restaurantRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Restaurant with id %s not found", id)));

            BeanUtils.copyProperties(restaurant, current, "id", "paymentMethods", "address", "products", "createdAt");
            current = restaurantService.save(current);

            return ResponseEntity.ok(current);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
