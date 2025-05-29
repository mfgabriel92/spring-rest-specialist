package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductsRequest {
    @Valid
    @NotEmpty
    private List<Product> products;

    @Getter
    @Setter
    public static class Product {
        @NotBlank
        private String name;

        private String description;

        @NotNull
        @PositiveOrZero
        private BigDecimal price;
    }
}