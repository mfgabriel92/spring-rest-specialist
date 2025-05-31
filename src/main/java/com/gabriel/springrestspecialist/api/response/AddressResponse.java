package com.gabriel.springrestspecialist.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private String street;
    private String number;
    private String city;
    private String state;
    private String zip;
}
