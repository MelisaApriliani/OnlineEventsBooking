package com.application.eventsbooking.exception;

import com.application.eventsbooking.dto.ApiResponseDTO;
import com.application.eventsbooking.factory.ApiResponseFactory;
import io.jsonwebtoken.io.DecodingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle user not found exception
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {

        return ApiResponseFactory.error(
                HttpStatus.NOT_FOUND.value(),
                "USER_NOT_FOUND",
                ex.getMessage()
        );
    }

    //Handle resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ApiResponseFactory.error(
                HttpStatus.NOT_FOUND.value(),
                "RESOURCE_NOT_FOUND",
                ex.getMessage()

        );
    }

    //Handle invalid argument exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ApiResponseFactory.error(
                HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_ERROR",
                errorMessage

        );
    }

    //Handle parameter type mismatch exception
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String errorMessage = String.format("Invalid value for parameter '%s'. Expected type is '%s'.",
                ex.getName(), ex.getRequiredType().getSimpleName());

        return ApiResponseFactory.error(
                HttpStatus.BAD_REQUEST.value(),
                "TYPE_MISMATCH",
                errorMessage
        );
    }

    // Handle missing required request parameter
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, WebRequest request) {
        String errorMessage = String.format("Missing required parameter '%s' of type '%s'.",
                ex.getParameterName(), ex.getParameterType());

        return ApiResponseFactory.error(
                HttpStatus.BAD_REQUEST.value(),
                "MISSING_REQUIRED_PARAMETER",
                errorMessage
        );
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleUserNotFoundException(InvalidArgumentException ex, WebRequest request) {
        return ApiResponseFactory.error(
                HttpStatus.BAD_REQUEST.value(),
                "INVALID_ARGUMENT",
                ex.getMessage()

        );
    }

    @ExceptionHandler(io.jsonwebtoken.io.DecodingException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleDecodingException(DecodingException ex, WebRequest request) {
        return ApiResponseFactory.error(                HttpStatus.BAD_REQUEST.value(),
                "AUTHENTICATION_ERROR",
                "Invalid JWT token format: " + ex.getMessage()
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        // Log the exception for debugging
        ex.printStackTrace();

        String errorMessage = "Malformed JSON request body: " + ex.getMessage();
        return ApiResponseFactory.error(
                HttpStatus.BAD_REQUEST.value(),
                "MALFORMED_JSON",
                errorMessage
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleBadCredentialsException(BadCredentialsException ex) {
        return ApiResponseFactory.error(
                HttpStatus.UNAUTHORIZED.value(),
                "BAD_CREDENTIALS",
                "Invalid username or password");


    }

    // Handle generic exceptions as a fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleGeneral(Exception ex, WebRequest request) {
        return ApiResponseFactory.error(                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_SERVER_ERROR",
                ex.getMessage()

        );
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponseDTO<Object>> handleNullPointer(Exception ex, WebRequest request) {
        return ApiResponseFactory.error(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "NULL_POINTER_EXCEPTION",
                ex.getMessage()

        );
    }
}
