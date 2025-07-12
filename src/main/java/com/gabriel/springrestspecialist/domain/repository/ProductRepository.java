package com.gabriel.springrestspecialist.domain.repository;

import com.gabriel.springrestspecialist.domain.model.Product;
import com.gabriel.springrestspecialist.domain.model.ProductPhoto;
import com.gabriel.springrestspecialist.infrastructure.repository.ProductRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, ProductRepositoryQueries {
    Optional<ProductPhoto> findPhotoById(UUID restaurantId, UUID productId);
}
