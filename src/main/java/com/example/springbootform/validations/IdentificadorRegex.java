package com.example.springbootform.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Constraint(validatedBy = IdentificadorRegexValidator.class)
public @interface IdentificadorRegex {

    String message() default "Pattern incorrecto.";

    Class<?>[] groups() default {};

    Class<? extends javax.validation.Payload>[] payload() default {};

}