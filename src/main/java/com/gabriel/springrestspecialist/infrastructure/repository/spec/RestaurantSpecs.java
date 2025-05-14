package com.gabriel.springrestspecialist.infrastructure.repository.spec;

import com.gabriel.springrestspecialist.domain.model.Restaurant;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class RestaurantSpecs {
    public static Specification<Restaurant> withNameLike(String name) {
        return ((root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }

    public static Specification<Restaurant> withDeliveryFeesBetween(BigDecimal minDeliveryFee, BigDecimal maxDeliveryFee) {
        return ((root, query, criteriaBuilder) ->
            criteriaBuilder.between(root.get("deliveryFee"), minDeliveryFee, maxDeliveryFee));
    }
}
