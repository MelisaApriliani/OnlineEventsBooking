package com.application.eventsbooking.factory;

import com.application.eventsbooking.dto.ApiResponseDTO;
import com.application.eventsbooking.dto.ErrorResponseDTO;
import com.application.eventsbooking.dto.DataDTO;
import com.application.eventsbooking.dto.SuccessResponseDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ApiResponseFactory {

    public static <T> ResponseEntity<ApiResponseDTO<T>> success(T data, String message) {
        return ResponseEntity.ok(new SuccessResponseDTO<>(200, message, data));
    }

    public static <T> ResponseEntity<ApiResponseDTO<T>> created(T data, String message) {
        return ResponseEntity.status(201).body(new SuccessResponseDTO<>(201, message, data));
    }

    public static <T> ResponseEntity<ApiResponseDTO> error(LocalDateTime date, int statusCode, String error) {
        return ResponseEntity.status(statusCode).body(new ErrorResponseDTO(statusCode, date, error));
    }
}
