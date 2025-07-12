package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.model.Restaurant;

import java.math.BigDecimal;
import java.util.List;

public interface RestaurantRepositoryQueries {
    List<Restaurant> findAllWithoutKitchen();

    List<Restaurant> findAllByNameAndDeliveryFee(String name, BigDecimal deliveryFee);

    List<Restaurant> findAllByNameLikeAndBetweenDeliveryFees(String name, BigDecimal minDeliveryFee, BigDecimal maxDeliveryFee);
}
