package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.PaymentMethod;
import com.gabriel.springrestspecialist.domain.repository.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod findById(UUID id) {
        return paymentMethodRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Payment method '%s' not found", id)));
    }
}
