package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.model.Restaurant;
import com.gabriel.springrestspecialist.domain.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.JoinType;
import java.math.BigDecimal;
import java.util.List;

import static com.gabriel.springrestspecialist.infrastructure.repository.spec.RestaurantSpecs.withDeliveryFeesBetween;
import static com.gabriel.springrestspecialist.infrastructure.repository.spec.RestaurantSpecs.withNameLike;

@Repository
@RequiredArgsConstructor(onConstructor_ = { @Lazy })
public class RestaurantRepositoryQueriesImpl implements RestaurantRepositoryQueries {
    @Lazy
    private final RestaurantRepository restaurantRepository;

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

    @Override
    public List<Restaurant> findAllByNameLikeAndBetweenDeliveryFees(String name, BigDecimal minDeliveryFee, BigDecimal maxDeliveryFee) {
        return restaurantRepository.findAll(withNameLike(name)
            .and(withDeliveryFeesBetween(minDeliveryFee, maxDeliveryFee))
        );
    }
}
