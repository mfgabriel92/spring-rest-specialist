package com.gabriel.springrestspecialist.api.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class OrderItemResponse {
    private UUID id;
    private BigDecimal unitPrice;
    private BigDecimal grandTotal;
    private int quantity;
    private String obs;
}
