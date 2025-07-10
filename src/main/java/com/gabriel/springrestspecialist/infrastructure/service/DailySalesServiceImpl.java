package com.gabriel.springrestspecialist.infrastructure.service;

import com.gabriel.springrestspecialist.domain.dto.DailySales;
import com.gabriel.springrestspecialist.domain.filter.DailySalesFilter;
import com.gabriel.springrestspecialist.domain.model.Order;
import com.gabriel.springrestspecialist.domain.service.DailySalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gabriel.springrestspecialist.domain.model.OrderStatus.CONFIRMED;
import static com.gabriel.springrestspecialist.domain.model.OrderStatus.DELIVERED;

@Repository
@RequiredArgsConstructor
public class DailySalesServiceImpl implements DailySalesService {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<DailySales> getDailySales(DailySalesFilter filter) {
        var builder = entityManager.getCriteriaBuilder();
        var query = builder.createQuery(DailySales.class);
        var root = query.from(Order.class);
        var predicates = new ArrayList<Predicate>();

        var dateOnly = truncateDate(builder, root, filter);
        var selection = builder.construct(
            DailySales.class,
            dateOnly,
            builder.count(root.get("id")),
            builder.sum(root.get("grandTotal"))
        );

        setFilters(filter, predicates, builder, root);
        predicates.add(root.get("status").in(CONFIRMED, DELIVERED));

        query.select(selection)
            .where(predicates.toArray(new Predicate[0]))
            .groupBy(dateOnly);

        return entityManager.createQuery(query).getResultList();
    }

    private void setFilters(DailySalesFilter filter, ArrayList<Predicate> predicates, CriteriaBuilder builder, Root<Order> root) {
        if (filter.getRestaurantId() != null) {
            predicates.add(builder.equal(root.get("restaurant").get("id"), filter.getRestaurantId()));
        }

        if (filter.getCreatedAtStart() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("createdAt"), filter.getCreatedAtStart()));
        }

        if (filter.getCreatedAtEnd() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("createdAt"), filter.getCreatedAtEnd()));
        }
    }

    private Expression<Date> truncateDate(CriteriaBuilder builder, Root<Order> root, DailySalesFilter filter) {
        return builder.function(
            "DATE_TRUNC",
            Date.class,
            builder.literal("day"),
            root.get("createdAt")
        );
    }
}
