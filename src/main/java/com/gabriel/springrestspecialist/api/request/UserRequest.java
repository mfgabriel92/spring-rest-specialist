package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRequest {
    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotBlank
    @Length(min = 8, max = 72)
    private String password;

    @NotBlank
    @Length(min = 8, max = 72)
    private String confirmPassword;
}
