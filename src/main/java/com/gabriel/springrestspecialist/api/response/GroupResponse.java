package com.gabriel.springrestspecialist.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class GroupResponse {
    private UUID id;
    private String name;
    private String description;
}
