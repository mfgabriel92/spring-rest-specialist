package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.api.request.ProductPhotoRequest;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Product;
import com.gabriel.springrestspecialist.domain.model.ProductPhoto;
import com.gabriel.springrestspecialist.domain.repository.RestaurantProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantProductService {
    private final RestaurantService restaurantService;
    private final ProductPhotoService productPhotoService;
    private final RestaurantProductRepository restaurantProductRepository;

    public Product findById(UUID restaurantId, UUID productId) {
        var restaurant = restaurantService.findById(restaurantId);
        return restaurantProductRepository.findById(restaurant.getId(), productId).orElseThrow(() ->
            new EntityNotFoundException(String.format("Product '%s' not found", productId)));
    }

    public List<Product> findAll(UUID restaurantId) {
        var restaurant = restaurantService.findById(restaurantId);
        return restaurantProductRepository.findAll(restaurant.getId());
    }

    @Transactional
    public void save(Product product) {
        restaurantProductRepository.save(product);
    }

    @Transactional
    public Product save(UUID restaurantId, UUID productId, Product product) {
        var restaurant = restaurantService.findById(restaurantId);
        var updated = findById(restaurant.getId(), productId);

        updated.setName(product.getName());
        updated.setDescription(product.getDescription());
        updated.setPrice(product.getPrice());

        return restaurantProductRepository.save(updated);
    }

    @Transactional
    public ProductPhoto uploadPhoto(UUID restaurantId, UUID productId, @Valid ProductPhotoRequest request) {
        var restaurant = restaurantService.findById(restaurantId);
        var product = findById(restaurant.getId(), productId);
        var fileName = UUID.randomUUID() + "-" + request.getFile().getOriginalFilename();
        var dir = Path.of("/Users/gabriel/Desktop", fileName);

        try {
            request.getFile().transferTo(dir);
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file", e);
        }

        var photo = new ProductPhoto();
        var file = request.getFile();
        photo.setProduct(product);
        photo.setName(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        photo.setFileSize(file.getSize());

        return productPhotoService.save(photo);
    }

    @Transactional
    public void deleteAllById(UUID restaurantId, List<UUID> productIds) {
        var restaurant = restaurantService.findById(restaurantId);
        var hasProductsToDelete = restaurant.getProducts()
            .stream()
            .anyMatch(p -> productIds.contains(p.getId()));

        if (!hasProductsToDelete) {
            throw new EntityNotFoundException(String.format("No products with these ids found in restaurant '%s'", restaurantId));
        }

        restaurantProductRepository.deleteAllByRestaurantAndProductIds(restaurant.getId(), productIds);
    }
}
