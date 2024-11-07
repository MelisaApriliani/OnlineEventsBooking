package com.application.eventsbooking.factory;

import com.application.eventsbooking.dto.ApiResponseDTO;
import com.application.eventsbooking.dto.ResponseDataDTO;
import org.springframework.http.ResponseEntity;

public class ApiResponseFactory {

    public static <T> ResponseEntity<ApiResponseDTO<ResponseDataDTO>> success(ResponseDataDTO data, String message) {
        return ResponseEntity.ok(new ApiResponseDTO<>(200, message, data));
    }

    public static <T> ResponseEntity<ApiResponseDTO<ResponseDataDTO>> created(ResponseDataDTO data, String message) {
        return ResponseEntity.status(201).body(new ApiResponseDTO<>(201, message, data));
    }

    public static <T> ResponseEntity<ApiResponseDTO<ResponseDataDTO>> error(String message, int statusCode) {
        return ResponseEntity.status(statusCode).body(new ApiResponseDTO<>(statusCode, message, null));
    }
}
