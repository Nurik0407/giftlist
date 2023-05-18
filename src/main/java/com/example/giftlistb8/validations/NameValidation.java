package com.example.giftlistb8.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidation implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = name.length() >= 2;
        if (!name.isEmpty()) {
            isValid = false;
        }
        if (name.matches(".*[A-Z].*")) {
            isValid = true;
        }
        if (name.matches(".*[a-z].*")) {
            isValid = true;
        }
        if (name.matches(".*[А-Я].*")) {
            isValid = true;
        }
        if (name.matches(".*[а-я].*")) {
            isValid = true;
        }
        return isValid;
    }
}
