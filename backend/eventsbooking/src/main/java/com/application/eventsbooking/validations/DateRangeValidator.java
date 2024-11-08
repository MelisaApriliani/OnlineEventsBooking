package com.application.eventsbooking.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, LocalDate> {

    private static final int MIN_DAYS_FROM_NOW = 3;
    private static final int MAX_MONTHS_FROM_NOW = 6;

    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null) {
            return true; // Let @NotNull handle null validation if needed
        }

        LocalDate now = LocalDate.now();
        LocalDate minDate = now.plusDays(MIN_DAYS_FROM_NOW);
        LocalDate maxDate = now.plusMonths(MAX_MONTHS_FROM_NOW);

        return date.isAfter(minDate) && date.isBefore(maxDate);
    }
}
