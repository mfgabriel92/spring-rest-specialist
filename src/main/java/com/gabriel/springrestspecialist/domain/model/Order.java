package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
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

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.OPEN;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    private OffsetDateTime confirmedAt;

    private OffsetDateTime deliveredAt;

    private OffsetDateTime cancelledAt;

    public BigDecimal getSubtotal() {
        return items.stream().map(OrderItem::getGrandTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getGrandTotal() {
        return getSubtotal().add(deliveryFee);
    }

    public void calculateGrandTotal() {
        getItems().forEach(OrderItem::calculateGrandTotal);
        this.subtotal = getSubtotal();
        this.grandTotal = getGrandTotal();
    }
}
