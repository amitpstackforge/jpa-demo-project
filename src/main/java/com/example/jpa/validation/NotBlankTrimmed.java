package com.example.jpa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotBlankTrimmedValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlankTrimmed {
    String message() default "Must not be blank or whitespace-only";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
