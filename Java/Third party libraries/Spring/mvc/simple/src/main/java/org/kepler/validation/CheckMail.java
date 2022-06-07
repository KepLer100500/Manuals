package org.kepler.validation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import javax.validation.Constraint;
import javax.validation.Payload;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckMailValidator.class)
public @interface CheckMail {

    public String value() default "xyz.com";
    public String message() default "Email must ends xyz.com";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

}