package com.application.eventsbooking.dto;

import java.time.LocalDateTime;

public class ErrorResponseDTO extends ApiResponseDTO{
    private LocalDateTime timestamp;
    private String error;

    public ErrorResponseDTO(int status) {
        super(status);
    }

    public ErrorResponseDTO(int status, LocalDateTime timestamp, String error) {
        super(status);
        this.timestamp = timestamp;
        this.error = error;
    }
}
