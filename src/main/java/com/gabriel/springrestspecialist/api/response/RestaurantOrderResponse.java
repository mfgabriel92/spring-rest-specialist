package com.gabriel.springrestspecialist.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantOrderResponse {
    private UUID id;
    private BigDecimal subtotal;
    private BigDecimal deliveryFee;
    private BigDecimal grandTotal;
    private AddressResponse deliveryAddress;
    private String status;

    private UUID paymentMethodId;
    private String paymentMethodName;

    private UUID userId;
    private String userName;
    private String userEmail;

    private List<OrderItemResponse> items;

    private OffsetDateTime createdAt;
    private OffsetDateTime confirmedAt;
    private OffsetDateTime deliveredAt;
    private OffsetDateTime cancelledAt;
}
