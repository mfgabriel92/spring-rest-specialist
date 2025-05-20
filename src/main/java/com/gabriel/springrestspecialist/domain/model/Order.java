package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal subtotal;

    private BigDecimal deliveryFee;

    private BigDecimal grandTotal;

    @Embedded
    private Address deliveryAddress;

    private OrderStatus status;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    private LocalDateTime createdAt;

    private LocalDateTime confirmedAt;

    private LocalDateTime deliveredAt;

    private LocalDateTime cancelledAt;
}
