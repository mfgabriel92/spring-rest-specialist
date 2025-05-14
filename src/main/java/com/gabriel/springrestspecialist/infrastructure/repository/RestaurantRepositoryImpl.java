package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.model.Restaurant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.JoinType;
import java.math.BigDecimal;
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

    @Override
    public List<Restaurant> findAllByNameAndDeliveryFee(String name, BigDecimal deliveryFee) {
        var criteriaBuilder = manager.getCriteriaBuilder();

        var criteriaQuery = criteriaBuilder.createQuery(Restaurant.class);
        var restaurantRoot = criteriaQuery.from(Restaurant.class);

        restaurantRoot.fetch("cuisine", JoinType.LEFT);

        var namePredicate = criteriaBuilder.like(restaurantRoot.get("name"), "%" + name + "%");
        var deliveryFeePredicate = criteriaBuilder.greaterThanOrEqualTo(restaurantRoot.get("deliveryFee"), deliveryFee);

        criteriaQuery.select(restaurantRoot).where(namePredicate, deliveryFeePredicate);

        var query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
