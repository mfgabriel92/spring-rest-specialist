package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    OPEN("Open"),
    DELIVERED("Delivered"),
    CONFIRMED("Confirmed"),
    CANCELED("Canceled"),
    REFUNDED("Refunded");

    private final String name;
}
