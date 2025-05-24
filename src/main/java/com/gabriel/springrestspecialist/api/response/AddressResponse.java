package com.gabriel.springrestspecialist.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class AddressResponse {
    private String street;
    private String number;

    @JsonProperty("city")
    private String cityName;

    @JsonProperty("state")
    private String cityStateName;
    private String zip;
}
