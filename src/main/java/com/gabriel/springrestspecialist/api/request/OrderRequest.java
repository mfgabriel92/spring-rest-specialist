package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderRequest {
    @NotNull
    private UUID userId;

    @NotNull
    private UUID restaurantId;

    @NotNull
    private UUID paymentMethodId;

    @Valid
    @NotNull
    private AddressRequest address;

    @Valid
    @NotEmpty
    private List<OrderItemRequest> items;
}
