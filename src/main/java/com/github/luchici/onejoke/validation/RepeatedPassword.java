package com.github.luchici.onejoke.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RepeatedPasswordValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatedPassword {

    String message() default "The Repeated Password meed to be the same as Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
