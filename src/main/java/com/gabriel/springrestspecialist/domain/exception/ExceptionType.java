package com.gabriel.springrestspecialist.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionType {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request", null),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found", null),
    CONFLICT(HttpStatus.CONFLICT, "Conflict", null),
    MESSAGE_NOT_READABLE(HttpStatus.BAD_REQUEST, "Message Not Readable", "The request body is invalid. Check for syntax error and try again");

    private final HttpStatus status;
    private final String title;
    private final String details;
}
