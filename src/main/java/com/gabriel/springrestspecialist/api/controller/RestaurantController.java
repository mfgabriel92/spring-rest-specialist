package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.RestaurantRequest;
import com.gabriel.springrestspecialist.api.response.RestaurantResponse;
import com.gabriel.springrestspecialist.domain.model.Restaurant;
import com.gabriel.springrestspecialist.domain.repository.RestaurantRepository;
import com.gabriel.springrestspecialist.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> findAll() {
        var restaurants = restaurantRepository.findAll();
        return ok(toModel(restaurants));
    }

    @GetMapping("{id}")
    public ResponseEntity<RestaurantResponse> findBId(@PathVariable UUID id) {
        var restaurant = restaurantService.findById(id);
        return ok(toModel(restaurant));
    }

    @GetMapping("containing")
    public ResponseEntity<List<RestaurantResponse>> findByNameContaining(String name) {
        var restaurants = restaurantRepository.findByNameContaining(name);
        return ok(toModel(restaurants));
    }

    @GetMapping("free-delivery")
    public ResponseEntity<List<RestaurantResponse>> findAllFreeDelivery() {
        var restaurants = restaurantRepository.findAllFreeDelivery();
        return ok(toModel(restaurants));
    }

    @GetMapping("no-kitchen")
    public ResponseEntity<List<RestaurantResponse>> findAllWithoutKitchen() {
        var restaurants = restaurantRepository.findAllWithoutKitchen();
        return ok(toModel(restaurants));
    }

    @GetMapping("name-with-delivery-fee")
    public ResponseEntity<List<RestaurantResponse>> findAllByNameAndDeliveryFee(String name, BigDecimal deliveryFee) {
        var restaurants = restaurantRepository.findAllByNameAndDeliveryFee(name, deliveryFee);
        return ok(toModel(restaurants));
    }

    @GetMapping("delivery-fees-between")
    public ResponseEntity<List<RestaurantResponse>> findAllByNameLikeAndBetweenDeliveryFees(String name, BigDecimal minDeliveryFee, BigDecimal maxDeliveryFee) {
        var restaurants = restaurantRepository.findAllByNameLikeAndBetweenDeliveryFees(name, minDeliveryFee, maxDeliveryFee);
        return ok(toModel(restaurants));
    }

    @GetMapping("latest")
    public ResponseEntity<RestaurantResponse> findLatestRegistered() {
        var restaurant = restaurantRepository.findLatestRegistered();
        return ok(toModel(restaurant));
    }

    @GetMapping("first")
    public ResponseEntity<RestaurantResponse> findFirstRegistered() {
        var restaurant = restaurantRepository.findFirstRegistered();
        return ok(toModel(restaurant));
    }

    @PostMapping
    public ResponseEntity<RestaurantResponse> save(@Valid @RequestBody RestaurantRequest request) {
        var restaurant = fromModel(request);
        var response = toModel(restaurantService.save(restaurant));
        return ResponseEntity.status(CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<RestaurantResponse> save(@PathVariable UUID id, @Valid @RequestBody RestaurantRequest request) {
        var current = restaurantService.findById(id);
        mapper.map(request, current);

        var response = toModel(restaurantService.save(current));
        return ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        restaurantService.deleteById(id);
        return noContent().build();
    }

    private void copyToDomainObj(RestaurantRequest request, Restaurant restaurant) {
        mapper.map(request, restaurant);
    }

    private Restaurant fromModel(RestaurantRequest request) {
        return mapper.map(request, Restaurant.class);
    }

    private RestaurantResponse toModel(Restaurant restaurant) {
        return mapper.map(restaurant, RestaurantResponse.class);
    }

    private List<RestaurantResponse> toModel(List<Restaurant> restaurants) {
        return restaurants.stream()
            .map(this::toModel)
            .toList();
    }
}
