package com.gabriel.springrestspecialist.api.exception;

import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.exception.EntityAlreadyInUseException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.exception.ExceptionType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static com.gabriel.springrestspecialist.domain.exception.ExceptionType.*;

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
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ResponseEntity<?> handleExceptionInternal(Exception ex, ExceptionType exType, WebRequest request) {
        var body = exceptionBuilder(ex, exType, request).build();
        return handleExceptionInternal(ex, body, new HttpHeaders(), exType.getStatus(), request);
    }

    private ExceptionMessage.ExceptionMessageBuilder exceptionBuilder(Exception ex, ExceptionType exType, WebRequest webRequest) {
        var url = getRequest(webRequest).getRequestURL().toString();

        return ExceptionMessage.builder()
            .status(exType.getStatus().value())
            .type(getExceptionType(exType, webRequest))
            .title(exType.getStatus().getReasonPhrase())
            .detail(ex.getMessage())
            .url(url)
            .timestamp(LocalDateTime.now());
    }

    private String getExceptionType(ExceptionType exType, WebRequest webRequest) {
        var request = getRequest(webRequest);
        var scheme = request.getScheme();
        var serverName = request.getServerName();
        var serverPort = request.getServerPort();
        var uri = exType.getStatus().getReasonPhrase().toLowerCase().replaceAll(" ", "-");

        return String.format("%s://%s:%s/errors/%s", scheme, serverName, serverPort, uri);
    }

    private HttpServletRequest getRequest(WebRequest request) {
        return ((ServletWebRequest) request).getRequest();
    }
}