package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product_photos")
@Getter
@Setter
public class ProductPhoto {
    @Id
    private UUID productId;

    private String name;

    private String contentType;

    private long fileSize;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Product product;
}
