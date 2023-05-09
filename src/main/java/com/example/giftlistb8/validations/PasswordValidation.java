package com.example.giftlistb8.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = password.length() >= 8;
        if (!password.matches(".*[A-Z].*")) {
            isValid = false;
        }
        if (!password.matches(".*[a-z].*")) {
            isValid = false;
        }
        if (!password.matches(".*\\d.*")) {
            isValid = false;
        }
        if (!password.matches(".*[0-9].*")) {
            isValid = false;
        }
        return isValid;
    }
}
