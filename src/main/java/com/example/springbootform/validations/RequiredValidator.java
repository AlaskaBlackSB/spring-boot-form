package com.example.springbootform.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequiredValidator implements ConstraintValidator<Required, String> {

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {

        // if (arg0 == null || arg0.isEmpty() || arg0.isBlank()) {
        if (arg0 == null || !StringUtils.hasText(arg0)) {
            return false;
        }

        return true;
    }

}