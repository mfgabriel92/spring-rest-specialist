package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserInfoRequest {
    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;
}
