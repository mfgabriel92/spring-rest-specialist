package com.gabriel.springrestspecialist.domain.repository;

import com.gabriel.springrestspecialist.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantOrderRepository extends JpaRepository<Order, UUID>, JpaSpecificationExecutor<Order> {
    @Query("FROM Order o JOIN FETCH o.user WHERE o.restaurant.id = :restaurantId")
    List<Order> findAllByRestaurantId(UUID restaurantId);

    Order findByRestaurantIdAndId(UUID restaurantId, UUID orderId);
}
