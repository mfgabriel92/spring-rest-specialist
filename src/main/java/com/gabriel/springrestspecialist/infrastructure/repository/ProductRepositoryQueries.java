package com.gabriel.springrestspecialist.infrastructure.repository;

import com.gabriel.springrestspecialist.domain.model.ProductPhoto;

public interface ProductRepositoryQueries {
    ProductPhoto savePhoto(ProductPhoto productPhoto);

    void removePhoto(ProductPhoto productPhoto);
}
