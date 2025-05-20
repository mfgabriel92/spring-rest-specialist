package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "address_city_id")
    private City city;

    @Column(name = "address_zip")
    private String zip;
}
