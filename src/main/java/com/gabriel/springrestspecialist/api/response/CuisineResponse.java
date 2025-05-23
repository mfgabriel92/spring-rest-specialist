package com.gabriel.springrestspecialist.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CuisineResponse {
    private UUID id;
    private String name;
}
