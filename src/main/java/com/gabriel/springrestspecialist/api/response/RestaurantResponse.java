package com.gabriel.springrestspecialist.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class RestaurantResponse {
    private UUID id;
    private String name;
    private BigDecimal deliveryFee;

    @JsonProperty("cuisine")
    private String cuisineName;
    private AddressResponse address;
    private boolean isActive;
    private boolean isOpen;
}
