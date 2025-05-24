package com.gabriel.springrestspecialist.api.request;

import com.gabriel.springrestspecialist.core.validation.DeliveryFee;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class RestaurantRequest {
    @NotBlank
    private String name;

    @NotNull
    @DeliveryFee
    private BigDecimal deliveryFee;

    @NotNull
    private UUID cuisineId;
}
