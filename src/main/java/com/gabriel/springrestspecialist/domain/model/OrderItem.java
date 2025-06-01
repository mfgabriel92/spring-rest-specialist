package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal unitPrice;

    private BigDecimal grandTotal;

    private BigDecimal promotionalDiscount;

    private int quantity;

    private String obs;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    public void calculateGrandTotal() {
        var grandTotal = unitPrice.multiply(new BigDecimal(quantity));
        setGrandTotal(grandTotal);
    }
}
