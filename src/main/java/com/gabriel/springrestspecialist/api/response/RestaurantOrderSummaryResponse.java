package com.gabriel.springrestspecialist.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantOrderSummaryResponse {
    private UUID id;
    private BigDecimal grandTotal;
    private String status;

    @JsonProperty("clientName")
    private String userName;
    private OffsetDateTime createdAt;
    private OffsetDateTime confirmedAt;
    private OffsetDateTime deliveredAt;
    private OffsetDateTime cancelledAt;
}
