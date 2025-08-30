package com.example.jpa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AllowedGenderValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedGender {
    String message() default "Gender must be one of: MALE, FEMALE, OTHER";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
