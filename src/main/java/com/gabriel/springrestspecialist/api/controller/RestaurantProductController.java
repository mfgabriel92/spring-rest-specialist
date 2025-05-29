package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.DeleteProductsRequest;
import com.gabriel.springrestspecialist.api.request.ProductRequest;
import com.gabriel.springrestspecialist.api.request.ProductsRequest;
import com.gabriel.springrestspecialist.api.response.ProductResponse;
import com.gabriel.springrestspecialist.domain.model.Product;
import com.gabriel.springrestspecialist.domain.service.RestaurantProductService;
import com.gabriel.springrestspecialist.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/restaurants/{restaurantId}/products")
@RequiredArgsConstructor
public class RestaurantProductController {
    private final RestaurantProductService restaurantProductService;
    private final RestaurantService restaurantService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(@PathVariable UUID restaurantId) {
        var products = restaurantProductService.findAll(restaurantId);
        return ok(toModel(products));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable UUID restaurantId, @PathVariable UUID productId) {
        var products = restaurantProductService.findById(restaurantId, productId);
        return ok(toModel(products));
    }

    @PostMapping
    public ResponseEntity<List<ProductResponse>> save(@PathVariable UUID restaurantId, @Valid @RequestBody ProductsRequest request) {
        var restaurant = restaurantService.findById(restaurantId);
        var products = request.getProducts().stream().map(p -> mapper.map(p, Product.class)).toList();
        products.forEach(p -> {
            p.setRestaurant(restaurant);
            restaurantProductService.save(p);
        });
        return ResponseEntity.status(HttpStatus.CREATED).body(toModel(products));
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductResponse> save(@PathVariable UUID restaurantId, @PathVariable UUID productId, @Valid @RequestBody ProductRequest request) {
        var product = mapper.map(request, Product.class);
        var response = restaurantProductService.save(restaurantId, productId, product);
        return ok(toModel(response));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID restaurantId, @Valid @RequestBody DeleteProductsRequest request) {
        var ids = request.getProducts()
            .stream()
            .map(p -> p.getId())
            .toList();
        restaurantProductService.deleteAllById(restaurantId, ids);
        return noContent().build();
    }


    private ProductResponse toModel(Product product) {
        return mapper.map(product, ProductResponse.class);
    }

    private List<ProductResponse> toModel(List<Product> products) {
        return products.stream()
            .map(this::toModel)
            .toList();
    }
}
