package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.model.Restaurant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepositoryImplQueries {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> findAllWithoutKitchen() {
        String jpql = "FROM Restaurant WHERE cuisine = NULL";
        return manager.createQuery(jpql, Restaurant.class).getResultList();
    }
}
