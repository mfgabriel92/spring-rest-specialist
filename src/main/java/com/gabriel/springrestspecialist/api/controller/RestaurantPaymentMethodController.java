package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.IdRequest;
import com.gabriel.springrestspecialist.api.response.PaymentMethodResponse;
import com.gabriel.springrestspecialist.domain.model.PaymentMethod;
import com.gabriel.springrestspecialist.domain.service.RestaurantPaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequestMapping("api/v1/restaurants/{id}/payment-methods")
@RequiredArgsConstructor
public class RestaurantPaymentMethodController {
    private final RestaurantPaymentMethodService restaurantPaymentMethodService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Set<PaymentMethodResponse>> getPaymentMethodsByRestaurantId(@PathVariable UUID id) {
        var paymentMethods = toModel(restaurantPaymentMethodService.getPaymentMethodsByRestaurantId(id));
        return ResponseEntity.ok(paymentMethods);
    }

    @PostMapping
    public ResponseEntity<Void> addPaymentMethod(@PathVariable UUID id, @Valid @RequestBody IdRequest request) {
        restaurantPaymentMethodService.addPaymentMethod(id, request.getId());
        return noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removePaymentMethod(@PathVariable UUID id, @Valid @RequestBody IdRequest request) {
        restaurantPaymentMethodService.removePaymentMethod(id, request.getId());
        return noContent().build();
    }

    private Set<PaymentMethodResponse> toModel(Set<PaymentMethod> paymentMethods) {
        return paymentMethods.stream()
            .map(pm -> mapper.map(pm, PaymentMethodResponse.class))
            .collect(Collectors.toSet());
    }
}
