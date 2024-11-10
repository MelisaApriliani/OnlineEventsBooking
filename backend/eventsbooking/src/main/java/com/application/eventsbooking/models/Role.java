package com.application.eventsbooking.models;

public enum Role {
    USER, ADMIN;

    public String getValue() {
        return switch (this) {
            case ADMIN -> "ADMIN";
            case USER -> "USER";
            default -> throw new IllegalArgumentException("Unexpected value: " + this);
        };
    }
}
