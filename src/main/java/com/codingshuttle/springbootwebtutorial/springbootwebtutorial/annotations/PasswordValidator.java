package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {

    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@$!%*?&]).{10,}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null)
            return true;

        return password.matches(PASSWORD_PATTERN);

    }

}
