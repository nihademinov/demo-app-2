package com.example.demoapp.exception;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.demoapp.config.HttpResponseConstants.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultErrorAttributes {

    private static final String ARGUMENT_VALIDATION_FAILED = "Argument validation failed";

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<Map<String, Object>> handle(AccessDeniedException ex, WebRequest request) {

        return ofType(request, HttpStatus.FORBIDDEN, "Bu funksionallığı istifadə etmək icazəniz yoxdur");
    }


    @ExceptionHandler(AlreadyExistsException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            AlreadyExistsException ex, WebRequest request) {
        return ofType(request, HttpStatus.CONFLICT, ex.getMessage());
    }


    @ExceptionHandler(SignatureException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            SignatureException ex, WebRequest request) {
        return ofType(request, HttpStatus.UNAUTHORIZED, ex.getMessage());
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            UserNotFoundException ex, WebRequest request) {
        return ofType(request, HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            NotFoundException ex, WebRequest request) {
        return ofType(request, HttpStatus.NOT_FOUND, ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(CustomValidationException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            CustomValidationException ex, WebRequest request) {
        log.warn("Validation Exception: {}", ex.getMessage());
        return ofType(request, HttpStatus.BAD_REQUEST, ex.getMessage());
    }



    @ExceptionHandler(OpenApiException.class)
    public final ResponseEntity<Map<String, Object>> handle(OpenApiException ex, WebRequest request) {
        return ofType(request, HttpStatus.CONFLICT, ex.getMessage());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            IllegalArgumentException ex, WebRequest request) {
        return ofType(request, HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        return ofType(request, HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MismatchedInputException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            MismatchedInputException ex, WebRequest request) {
        return ofType(request, HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Map<String, Object>> handle(
            MethodArgumentNotValidException ex,
            WebRequest request) {
        List<ConstraintsViolationError> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ConstraintsViolationError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        return ofType(request, HttpStatus.BAD_REQUEST, ARGUMENT_VALIDATION_FAILED, validationErrors, 0);
    }

    private ResponseEntity<Map<String, Object>> ofType(WebRequest request, HttpStatus status, String message, int errorCode) {
        return ofType(request, status, message, Collections.EMPTY_LIST, errorCode);
    }

    private ResponseEntity<Map<String, Object>> ofType(WebRequest request, HttpStatus status, String message) {
        return ofType(request, status, message, Collections.EMPTY_LIST, 0);
    }

    private ResponseEntity<Map<String, Object>> ofType(
            WebRequest request, HttpStatus status, String message, List validationErrors, int errorCode) {
        Map<String, Object> attributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        attributes.put(STATUS, status.value());
        attributes.put(ERROR, status.getReasonPhrase());
        attributes.put(MESSAGE, message);
        attributes.put(ERROR_CODE, errorCode);
        attributes.put(ERRORS, validationErrors);
        attributes.put(PATH, ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(attributes, status);
    }

}

