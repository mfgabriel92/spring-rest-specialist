package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.model.ProductPhoto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProductRepositoryQueriesImpl implements ProductRepositoryQueries {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public ProductPhoto savePhoto(ProductPhoto productPhoto) {
        return entityManager.merge(productPhoto);
    }

    @Transactional
    @Override
    public void removePhoto(ProductPhoto productPhoto) {
        entityManager.remove(productPhoto);
    }
}
