package org.kepler.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CheckMailValidator implements ConstraintValidator<CheckMail, String> {
    private String endOfEmail;

    @Override
    public void initialize(CheckMail checkMail) {
        endOfEmail = checkMail.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }

}