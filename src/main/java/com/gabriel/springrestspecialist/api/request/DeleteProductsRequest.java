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
public class DeleteProductsRequest {
    @Valid
    @NotEmpty
    private List<Product> products;

    @Getter
    @Setter
    public static class Product {
        @NotNull
        private UUID id;
    }
}