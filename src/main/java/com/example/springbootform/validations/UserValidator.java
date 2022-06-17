package com.example.springbootform.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.springbootform.models.domain.User;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    /** En este metodo se pueden agregar todos los campos de la clase user */
    @Override
    public void validate(Object target, Errors errors) {
        // User user = (User) target;

        // Valida el nombre
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.user.name");

        // Esto se comenta porque ahora se validacon @IdentificadorRegex
        // Valida el pattern
        // if (!user.getPattern().matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"))
        // {
        // errors.rejectValue("pattern", "Pattern.user.pattern");
        // }

    }

}