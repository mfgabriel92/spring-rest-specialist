package com.gabriel.springrestspecialist.infrastructure.repository.spec;

import com.gabriel.springrestspecialist.domain.filter.OrderFilter;
import com.gabriel.springrestspecialist.domain.model.Order;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class OrderSpecs {
    public static Specification<Order> withFilter(OrderFilter filter) {
        return ((root, query, criteriaBuilder) -> {
            root.fetch("user");
            root.fetch("restaurant").fetch("cuisine");

            var predicates = new ArrayList<Predicate>();

            if (filter.getUserId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("user").get("id"), filter.getUserId()));
            }

            if (filter.getRestaurantId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("restaurant").get("id"), filter.getRestaurantId()));
            }

            if (filter.getCreatedAtStart() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), filter.getCreatedAtStart()));
            }

            if (filter.getCreatedAtEnd() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), filter.getCreatedAtEnd()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
