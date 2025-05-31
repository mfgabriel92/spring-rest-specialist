package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddressRequest {
    @NotBlank
    private String street;
    private String apartmentNumber;
    @NotBlank
    private String number;

    @NotBlank
    private String zip;

    @NotBlank
    private String city;

    @NotBlank
    private String state;
}
