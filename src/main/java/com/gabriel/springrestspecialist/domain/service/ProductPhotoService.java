package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.model.ProductPhoto;
import com.gabriel.springrestspecialist.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductPhotoService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductPhoto save(ProductPhoto productPhoto) {
        var restaurantId = productPhoto.getProduct().getRestaurant().getId();
        var productId = productPhoto.getProduct().getId();
        var photo = productRepository.findPhotoById(restaurantId, productId);

        photo.ifPresent(productRepository::removePhoto);

        return productRepository.savePhoto(productPhoto);
    }

    @Transactional
    public void remove() {
    }
}
