package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    OPEN("Open"),
    CONFIRMED("Confirmed", OPEN),
    DELIVERED("Delivered", CONFIRMED),
    CANCELED("Canceled", OPEN, CONFIRMED),
    REFUNDED("Refunded", CONFIRMED);

    private final String name;
    private final List<OrderStatus> previousStatuses;

    OrderStatus(String name, OrderStatus... previousStatuses) {
        this.name = name;
        this.previousStatuses = List.of(previousStatuses);
    }

    public boolean cannotAlterToStatus(OrderStatus status) {
        return !status.previousStatuses.contains(this);
    }
}
