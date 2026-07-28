package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {PrimeNumberValidator.class})
public @interface PrimeNumberValidation {

    String message() default "The number must be a prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}