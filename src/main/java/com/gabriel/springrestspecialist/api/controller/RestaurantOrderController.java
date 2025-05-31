package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.response.RestaurantOrderResponse;
import com.gabriel.springrestspecialist.api.response.RestaurantOrderSummaryResponse;
import com.gabriel.springrestspecialist.domain.model.Order;
import com.gabriel.springrestspecialist.domain.service.RestaurantOrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/restaurants/{id}/orders")
@RequiredArgsConstructor
public class RestaurantOrderController {
    private final RestaurantOrderService restaurantOrderService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RestaurantOrderSummaryResponse>> findAllOrdersByRestaurantId(@PathVariable UUID id) {
        var response = restaurantOrderService.findAllByRestaurantId(id);
        return ok(toSummaryModel(response));
    }

    @GetMapping("{orderId}")
    public ResponseEntity<RestaurantOrderResponse> findByRestaurantIdAndId(@PathVariable UUID id, @PathVariable UUID orderId) {
        var response = restaurantOrderService.findByRestaurantIdAndId(id, orderId);
        return ok(toModel(response));
    }

    private RestaurantOrderResponse toModel(Order order) {
        return mapper.map(order, RestaurantOrderResponse.class);
    }

    private List<RestaurantOrderSummaryResponse> toSummaryModel(List<Order> orders) {
        return orders.stream()
            .map(o -> mapper.map(o, RestaurantOrderSummaryResponse.class))
            .toList();
    }
}
