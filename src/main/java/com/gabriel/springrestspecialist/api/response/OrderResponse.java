package com.gabriel.springrestspecialist.api.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderResponse {
    private UUID orderId;
    private UUID userId;
    private UUID restaurantId;
    private UUID paymentMethodId;
    private String status;
    private AddressResponse deliveryAddress;
    private List<OrderItemResponse> items;
    private BigDecimal subtotal;
    private BigDecimal deliveryFee;
    private BigDecimal grandTotal;
    private OffsetDateTime createdAt;
}
