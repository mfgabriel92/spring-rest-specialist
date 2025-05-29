package com.gabriel.springrestspecialist.domain.repository;

import com.gabriel.springrestspecialist.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestaurantProductRepository extends JpaRepository<Product, UUID> {
    @Query("FROM Product WHERE restaurant.id = :restaurantId")
    List<Product> findAll(UUID restaurantId);

    @Query("FROM Product WHERE restaurant.id = :restaurantId AND id = :productId")
    Optional<Product> findById(UUID restaurantId, UUID productId);

    @Modifying
    @Query("DELETE FROM Product WHERE restaurant.id = :restaurantId AND id IN :productIds")
    void deleteAllByRestaurantAndProductIds(UUID restaurantId, List<UUID> productIds);
}
