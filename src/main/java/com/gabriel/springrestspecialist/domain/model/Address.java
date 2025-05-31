package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {
    @Column(name = "address_street")
    private String street;

    @Column(name = "address_apartment_number")
    private String apartmentNumber;

    @Column(name = "address_number")
    private String number;

    @Column(name = "address_city")
    private String city;

    @Column(name = "address_state")
    private String state;

    @Column(name = "address_zip")
    private String zip;
}
