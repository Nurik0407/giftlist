package com.example.giftlistb8.annotation;

import com.example.giftlistb8.dto.user.requests.ResetPasswordRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        ResetPasswordRequest request = (ResetPasswordRequest) object;
        return request.getPassword().equals(request.getConfirmPassword());
    }
}
