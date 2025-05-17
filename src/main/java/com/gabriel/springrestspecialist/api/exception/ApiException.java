package com.gabriel.springrestspecialist.api.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ApiException {
    private String message;
    private LocalDateTime timestamp;
}
