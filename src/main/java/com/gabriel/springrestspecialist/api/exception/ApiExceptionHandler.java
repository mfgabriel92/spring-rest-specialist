package com.gabriel.springrestspecialist.api.exception;

import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.exception.EntityAlreadyInUseException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<?> handleBusinessLogicException(BusinessLogicException e) {
        return handleException(e, BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException e) {
        return handleException(e, NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyInUseException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityAlreadyInUseException e) {
        return handleException(e, CONFLICT);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<?> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return handleException(e, UNSUPPORTED_MEDIA_TYPE);
    }

    private ResponseEntity<?> handleException(Throwable e, HttpStatus status) {
        var apiException = exceptionResponseBuilder(e.getMessage()).build();
        return ResponseEntity.status(status).body(apiException);
    }

    private ApiException.ApiExceptionBuilder exceptionResponseBuilder(String message) {
        return ApiException.builder()
            .message(message)
            .timestamp(LocalDateTime.now());
    }
}
