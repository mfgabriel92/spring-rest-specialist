package com.gabriel.springrestspecialist.infrastructure.service;

import com.gabriel.springrestspecialist.domain.dto.DailySales;
import com.gabriel.springrestspecialist.domain.filter.DailySalesFilter;
import com.gabriel.springrestspecialist.domain.model.Order;
import com.gabriel.springrestspecialist.domain.service.DailySalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

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

        var dateOnly = builder.function("DATE_TRUNC", Date.class,
            builder.literal("day"), root.get("createdAt"));
        var selection = builder.construct(
            DailySales.class,
            dateOnly,
            builder.count(root.get("id")),
            builder.sum(root.get("grandTotal"))
        );

        query.select(selection);
        query.groupBy(dateOnly);

        return entityManager.createQuery(query).getResultList();
    }
}
