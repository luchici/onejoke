package com.github.luchici.onejoke.validation;

import com.github.luchici.onejoke.model.UserUpdate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class RepeatedPasswordValidator implements ConstraintValidator<RepeatedPassword, UserUpdate> {

    @Override
    public boolean isValid(UserUpdate value, ConstraintValidatorContext context) {
        return Objects.equals(value.getPassword(), value.getRepeatedPassword());
    }
}
