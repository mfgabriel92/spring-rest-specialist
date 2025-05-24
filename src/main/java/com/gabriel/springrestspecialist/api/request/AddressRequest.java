package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
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

    @Valid
    @NotNull
    private CityId city;

    @Getter
    @Setter
    private static class CityId {
        @NotNull
        private UUID id;
    }
}
