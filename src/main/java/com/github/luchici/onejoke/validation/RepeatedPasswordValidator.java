package com.github.luchici.onejoke.validation;

import com.github.luchici.onejoke.model.UserUpdateFormData;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class RepeatedPasswordValidator implements ConstraintValidator<RepeatedPassword, UserUpdateFormData> {

    @Override
    public boolean isValid(UserUpdateFormData value, ConstraintValidatorContext context) {
        return Objects.equals(value.getPassword(), value.getRepeatedPassword());
    }
}
