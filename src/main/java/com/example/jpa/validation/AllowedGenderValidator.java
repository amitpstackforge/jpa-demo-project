package com.example.jpa.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class AllowedGenderValidator implements ConstraintValidator<AllowedGender, String> {
    private static final Set<String> ALLOWED = Set.of("MALE", "FEMALE", "OTHER");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // null check অন্য অ্যানোটেশন (যেমন @NotNull) করবে
        return ALLOWED.contains(value.toUpperCase().trim());
    }
}
