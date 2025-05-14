package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.domain.model.Restaurant;
import com.gabriel.springrestspecialist.domain.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    @GetMapping
    public ResponseEntity<List<Restaurant>> findAll() {
        return ok(restaurantRepository.findAll());
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
    public ResponseEntity<List<Restaurant>> findAllByNameLikeAndBetweenDeliveryFees(
        String name,
        BigDecimal minDeliveryFee,
        BigDecimal maxDeliveryFee
    ) {
        return ok(restaurantRepository.findAllByNameLikeAndBetweenDeliveryFees(name, minDeliveryFee, maxDeliveryFee));
    }
}
