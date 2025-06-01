package com.gabriel.springrestspecialist.api.request;

import com.gabriel.springrestspecialist.core.validation.ValidEnum;
import com.gabriel.springrestspecialist.domain.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OrderStatusRequest {
    @NotBlank
    @ValidEnum(enumClass = OrderStatus.class)
    private String status;
}
