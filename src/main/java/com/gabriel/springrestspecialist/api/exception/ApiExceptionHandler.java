package com.gabriel.springrestspecialist.api.exception;

import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.exception.EntityAlreadyInUseException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<?> handleBusinessLogicException(BusinessLogicException ex, WebRequest request) {
        return handleExceptionInternal(ex, BAD_REQUEST, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, NOT_FOUND, request);
    }

    @ExceptionHandler(EntityAlreadyInUseException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityAlreadyInUseException ex, WebRequest request) {
        return handleExceptionInternal(ex, CONFLICT, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        body = ApiException.builder()
            .message(ex.getMessage())
            .timestamp(LocalDateTime.now())
            .build();

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ResponseEntity<?> handleExceptionInternal(Exception ex, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), status, request);
    }
}
