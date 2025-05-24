package com.gabriel.springrestspecialist.api.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class RestaurantResponse {
    private UUID id;
    private String name;
    private BigDecimal deliveryFee;
    private String cuisineName;
    private String addressStreet;
    private String addressNumber;
    private String addressCityName;
    private String addressZip;
    private boolean isActive;
}
