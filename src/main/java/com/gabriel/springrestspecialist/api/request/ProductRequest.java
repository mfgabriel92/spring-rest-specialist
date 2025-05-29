package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;
}