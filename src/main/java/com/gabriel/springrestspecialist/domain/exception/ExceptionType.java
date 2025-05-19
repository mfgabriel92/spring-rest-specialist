package com.gabriel.springrestspecialist.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionType {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Error"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
    CONFLICT(HttpStatus.CONFLICT, "Conflict"),
    MESSAGE_NOT_READABLE(HttpStatus.BAD_REQUEST, "Message Not Readable"),
    JSON_PARSE(HttpStatus.BAD_REQUEST, "JSON Parse Error"),
    INVALID_FORMAT(HttpStatus.BAD_REQUEST, "Invalid Format"),
    UNRECOGNIZED_PROPERTY(HttpStatus.BAD_REQUEST, "Unrecognized Property"),
    IGNORED_PROPERTY(HttpStatus.BAD_REQUEST, "Unrecognized Property"),
    TYPE_MISMATCH(HttpStatus.BAD_REQUEST, "Type Mistmach"),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "Validation Error");

    private final HttpStatus status;
    private final String title;
}
