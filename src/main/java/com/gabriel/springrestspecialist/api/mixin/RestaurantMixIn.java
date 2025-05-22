package com.gabriel.springrestspecialist.api.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gabriel.springrestspecialist.domain.model.Address;
import com.gabriel.springrestspecialist.domain.model.Cuisine;
import com.gabriel.springrestspecialist.domain.model.PaymentMethod;
import com.gabriel.springrestspecialist.domain.model.Product;

import java.util.List;

public class RestaurantMixIn {
    @JsonIgnoreProperties(value = "name", allowGetters = true)
    private Cuisine cuisine;

    @JsonIgnore
    private List<PaymentMethod> paymentMethods;

    @JsonIgnore
    private Address address;

    @JsonIgnore
    private List<Product> products;
}
