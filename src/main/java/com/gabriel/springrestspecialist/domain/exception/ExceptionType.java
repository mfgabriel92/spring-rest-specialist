package com.gabriel.springrestspecialist.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionType {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
    CONFLICT(HttpStatus.CONFLICT, "Conflict");

    private final HttpStatus status;
    private final String title;
}
