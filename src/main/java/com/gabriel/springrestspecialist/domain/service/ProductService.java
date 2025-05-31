package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Product;
import com.gabriel.springrestspecialist.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Product '%s' not found", id)));
    }
}
