package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.repository.CustomJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CustomJpaRepositoryImpl<T, ID>
    extends SimpleJpaRepository<T, ID>
    implements CustomJpaRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findLatestRegistered() {
        var jpql = "FROM " + getDomainClass().getName() + " ORDER BY %s DESC";
        var query = String.format(jpql, "created_at");

        T entity = entityManager.createQuery(query, getDomainClass())
            .setMaxResults(1)
            .getSingleResult();

        return Optional.ofNullable(entity);
    }

    @Override
    public Optional<T> findFirstRegistered() {
        var jpql = "FROM " + getDomainClass().getName() + " ORDER BY %s ASC";
        var query = String.format(jpql, "created_at");

        T entity = entityManager.createQuery(query, getDomainClass())
            .setMaxResults(1)
            .getSingleResult();

        return Optional.ofNullable(entity);
    }
}
