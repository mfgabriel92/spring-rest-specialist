package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.OrderRequest;
import com.gabriel.springrestspecialist.api.response.OrderResponse;
import com.gabriel.springrestspecialist.domain.model.Order;
import com.gabriel.springrestspecialist.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@Valid @RequestBody OrderRequest request) {
        var order = orderService.save(fromModel(request));
        return ResponseEntity.status(CREATED).body(toModel(order));
    }

    private Order fromModel(OrderRequest order) {
        return mapper.map(order, Order.class);
    }

    private OrderResponse toModel(Order order) {
        return mapper.map(order, OrderResponse.class);
    }
}
