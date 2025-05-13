package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepositoryImplQueries {
    List<Restaurant> findAllWithoutKitchen();
}
