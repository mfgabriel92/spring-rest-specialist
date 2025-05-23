package com.gabriel.springrestspecialist.domain.model;

import com.gabriel.springrestspecialist.core.validation.ZeroValueIncludesFlag;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@ZeroValueIncludesFlag(sourceProperty = "deliveryFee", targetProperty = "name", flagValue = "Free Delivery - ")
@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private BigDecimal deliveryFee;

    @ManyToOne
    @JoinColumn
    private Cuisine cuisine;

    @ManyToMany
    @JoinTable(
        name = "restaurants_payment_methods",
        joinColumns = @JoinColumn(name = "restaurant_id"),
        inverseJoinColumns = @JoinColumn(name = "payment_method_id")
    )
    private List<PaymentMethod> paymentMethods;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "restaurant")
    private List<Product> products;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
