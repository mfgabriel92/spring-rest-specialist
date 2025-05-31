package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

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

    @NotNull
    private UUID cityId;
}
