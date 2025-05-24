package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PasswordRequest {
    @NotBlank
    private String currentPassword;

    @NotBlank
    private String password;
}
