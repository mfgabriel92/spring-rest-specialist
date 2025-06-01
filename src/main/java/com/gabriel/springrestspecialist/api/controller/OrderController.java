package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.OrderRequest;
import com.gabriel.springrestspecialist.api.request.OrderStatusRequest;
import com.gabriel.springrestspecialist.api.response.OrderResponse;
import com.gabriel.springrestspecialist.domain.model.Order;
import com.gabriel.springrestspecialist.domain.model.OrderStatus;
import com.gabriel.springrestspecialist.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;

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

    @PutMapping("{id}/status")
    public ResponseEntity<Void> changeStatus(@PathVariable UUID id, @Valid @RequestBody OrderStatusRequest request) {
        var status = OrderStatus.valueOf(request.getStatus());
        orderService.changeStatus(id, status);
        return noContent().build();
    }

    private Order fromModel(OrderRequest order) {
        return mapper.map(order, Order.class);
    }

    private OrderResponse toModel(Order order) {
        return mapper.map(order, OrderResponse.class);
    }
}
