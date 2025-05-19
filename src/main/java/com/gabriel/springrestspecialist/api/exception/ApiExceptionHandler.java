package com.gabriel.springrestspecialist.api.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.exception.EntityAlreadyInUseException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.exception.ExceptionType;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.gabriel.springrestspecialist.domain.exception.ExceptionType.*;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private static List<ExceptionMessage.Field> getFieldsWithErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(f -> ExceptionMessage.Field.builder()
                .name(f.getField())
                .error(f.getDefaultMessage())
                .build()
            ).collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaughtExceptions(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, INTERNAL_SERVER_ERROR, "An unknown error has happened. Please try again", request);
    }

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<?> handleBusinessLogicException(BusinessLogicException ex, WebRequest request) {
        return handleExceptionInternal(ex, BAD_REQUEST, null, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, NOT_FOUND, null, request);
    }

    @ExceptionHandler(EntityAlreadyInUseException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityAlreadyInUseException ex, WebRequest request) {
        return handleExceptionInternal(ex, CONFLICT, null, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var rootCause = ExceptionUtils.getRootCause(ex);

        if (rootCause instanceof JsonParseException e) {
            return handleJsonParseException(e, JSON_PARSE, request);
        } else if (rootCause instanceof InvalidFormatException e) {
            return handleInvalidFormatException(e, INVALID_FORMAT, request);
        } else if (rootCause instanceof UnrecognizedPropertyException e) {
            return handleUnrecognizedPropertyException(e, UNRECOGNIZED_PROPERTY, request);
        } else if (rootCause instanceof IgnoredPropertyException e) {
            return handleIgnoredPropertyException(e, IGNORED_PROPERTY, request);
        }

        var details = "The request body is invalid. Check for syntax error and try again";
        return handleExceptionInternal(ex, MESSAGE_NOT_READABLE, details, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentTypeMismatchException e) {
            return handleMethodArgumentTypeMismatch(e, TYPE_MISMATCH, request);
        }

        return handleExceptionInternal(ex, BAD_REQUEST, ex.getMessage(), request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var detail = String.format("The requested resource '%s' does not exist", ex.getRequestURL());
        return handleExceptionInternal(ex, NOT_FOUND, detail, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var exType = VALIDATION_ERROR;
        var body = exceptionBuilder(ex, exType, "One or more fields contain errors. Please correct them and try again", request)
            .fields(getFieldsWithErrors(ex))
            .build();
        return handleExceptionInternal(ex, body, new HttpHeaders(), exType.getStatus(), request);
    }

    private ResponseEntity<Object> handleJsonParseException(JsonParseException ex, ExceptionType exType, WebRequest request) {
        var details = "The request JSON format contains syntax errors. Please correct it and try again";
        return handleExceptionInternal(ex, exType, details, request);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, ExceptionType exType, WebRequest request) {
        var propertyName = ex.getPath().stream()
            .map(ref -> ref.getFieldName())
            .collect(Collectors.joining("."));
        var details = String.format(
            "The property '%s' has received an invalid value '%s', when it expects the type '%s'. Please correct it and try again",
            propertyName,
            ex.getValue(),
            ex.getTargetType().getSimpleName()
        );
        return handleExceptionInternal(ex, exType, details, request);
    }

    private ResponseEntity<Object> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex, ExceptionType exType, WebRequest request) {
        var details = String.format("The property '%s' does not exist", ex.getPropertyName());
        return handleExceptionInternal(ex, exType, details, request);
    }

    private ResponseEntity<Object> handleIgnoredPropertyException(IgnoredPropertyException ex, ExceptionType exType, WebRequest request) {
        var details = String.format("The property '%s' does not exist", ex.getPropertyName());
        return handleExceptionInternal(ex, exType, details, request);
    }

    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, ExceptionType exType, WebRequest request) {
        var details = String.format(
            "The parameter '%s' has received an invalid value '%s', when it expects the type '%s'. Please correct it and try again",
            ex.getName(),
            ex.getValue(),
            ex.getRequiredType().getSimpleName()
        );
        return handleExceptionInternal(ex, exType, details, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception ex, ExceptionType exType, String details, WebRequest request) {
        var body = exceptionBuilder(ex, exType, details, request).build();
        return handleExceptionInternal(ex, body, new HttpHeaders(), exType.getStatus(), request);
    }

    private ExceptionMessage.ExceptionMessageBuilder exceptionBuilder(Exception ex, ExceptionType exType, String details, WebRequest webRequest) {
        var url = getRequest(webRequest).getRequestURL().toString();
        details = details != null
            ? details
            : ex.getMessage();

        return ExceptionMessage.builder()
            .status(exType.getStatus().value())
            .type(getExceptionType(exType, webRequest))
            .title(exType.getTitle())
            .detail(details)
            .url(url)
            .timestamp(LocalDateTime.now());
    }

    private String getExceptionType(ExceptionType exType, WebRequest webRequest) {
        var request = getRequest(webRequest);
        var scheme = request.getScheme();
        var serverName = request.getServerName();
        var serverPort = request.getServerPort();
        var uri = exType.getTitle().toLowerCase().replaceAll(" ", "-");

        return String.format("%s://%s:%s/errors/%s", scheme, serverName, serverPort, uri);
    }

    private HttpServletRequest getRequest(WebRequest request) {
        return ((ServletWebRequest) request).getRequest();
    }
}