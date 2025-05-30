package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    private Set<PaymentMethod> paymentMethods;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "restaurant")
    private List<Product> products;

    private boolean isActive;

    private boolean isOpen;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    public void activate() {
        setActive(true);
    }

    public void deactivate() {
        setActive(false);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        getPaymentMethods().add(paymentMethod);
    }

    public void removePaymentMethod(PaymentMethod paymentMethod) {
        getPaymentMethods().remove(paymentMethod);
    }

    public void open() {
        setOpen(true);
    }

    public void close() {
        setOpen(false);
    }
}
