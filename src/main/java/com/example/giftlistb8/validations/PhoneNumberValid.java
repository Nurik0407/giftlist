package com.example.giftlistb8.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValid implements ConstraintValidator<ValidPhone,String> {
    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        if (number == null) {
            return false;
        }
        String pattern = "^\\+[0-9]{10,}$";
        return number.matches(pattern);

    }
}
