package com.gabriel.springrestspecialist.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    private boolean active;

    @ManyToOne
    @JoinColumn
    private Restaurant restaurant;
}
