package com.gaebaljip.exceed.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    public static String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\W).{6,}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password.matches(PASSWORD_REGEX);
    }
}
