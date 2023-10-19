package com.github.luchici.onejoke.validation.updateUser;

import static com.github.luchici.onejoke.validation.updateUser.UserUpdateValidationUtility.validUserUpdate;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.luchici.onejoke.model.UserUpdateFormData;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class UserUpdateFormDataValidationTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @ParameterizedTest
    @MethodSource("com.github.luchici.onejoke.validation.updateUser.UserUpdateValidationUtility#provideUsersWithInvalidFirstname")
    void userUpdate_ValidationThrowException_WithInvalidFirstname(UserUpdateFormData userUpdateFormData) {
        Set<String> expectedValue = Set.of("firstName");
        Set<ConstraintViolation<UserUpdateFormData>> violations = validator.validate(userUpdateFormData);
        Set<String> actualValue = violations.stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet());
        assertThat(actualValue)
            .hasSize(1)
            .containsAll(expectedValue);
    }

    @ParameterizedTest
    @MethodSource("com.github.luchici.onejoke.validation.updateUser.UserUpdateValidationUtility#provideUsersWithInvalidLastname")
    void userUpdate_ValidationThrowException_WithInvalidLastname(UserUpdateFormData userUpdateFormData) {
        Set<String> expectedValue = Set.of("lastName");
        Set<ConstraintViolation<UserUpdateFormData>> violations = validator.validate(userUpdateFormData);
        Set<String> actualValue = violations.stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet());
        assertThat(actualValue)
            .hasSize(1)
            .containsAll(expectedValue);
    }

    @ParameterizedTest
    @MethodSource("com.github.luchici.onejoke.validation.updateUser.UserUpdateValidationUtility#provideUsersWithInvalidUsername")
    void userUpdate_ValidationThrowException_WithInvalidUsername(UserUpdateFormData userUpdateFormData) {
        Set<String> expectedValue = Set.of("username");
        Set<ConstraintViolation<UserUpdateFormData>> violations = validator.validate(userUpdateFormData);
        Set<String> actualValue = violations.stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet());
        assertThat(actualValue)
            .hasSize(1)
            .containsAll(expectedValue);
    }

    @ParameterizedTest
    @MethodSource("com.github.luchici.onejoke.validation.updateUser.UserUpdateValidationUtility#provideUsersWithInvalidLocalDate")
    void userUpdate_ValidationThrowException_WithInvalidLocalDate(UserUpdateFormData userUpdateFormData) {
        Set<String> expectedValue = Set.of("dob");
        Set<ConstraintViolation<UserUpdateFormData>> violations = validator.validate(userUpdateFormData);
        Set<String> actualValue = violations.stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet());
        assertThat(actualValue)
            .hasSize(1)
            .containsAll(expectedValue);
    }

    @ParameterizedTest
    @MethodSource("com.github.luchici.onejoke.validation.updateUser.UserUpdateValidationUtility#provideUsersWithInvalidEmail")
    void userUpdate_ValidationThrowException_WithInvalidEmail(UserUpdateFormData userUpdateFormData) {
        Set<String> expectedValue = Set.of("email");
        Set<ConstraintViolation<UserUpdateFormData>> violations = validator.validate(userUpdateFormData);
        Set<String> actualValue = violations.stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet());
        assertThat(actualValue)
            .hasSize(1)
            .containsAll(expectedValue);
    }

    @ParameterizedTest
    @MethodSource("com.github.luchici.onejoke.validation.updateUser.UserUpdateValidationUtility#provideUsersWithInvalidPassword")
    void userUpdate_ValidationThrowException_WithInvalidPassword(UserUpdateFormData userUpdateFormData) {
        Set<String> expectedValue = Set.of("password");
        Set<ConstraintViolation<UserUpdateFormData>> violations = validator.validate(userUpdateFormData);

        Set<String> actualValue = violations.stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet());

        assertThat(actualValue)
            .hasSize(1)
            .containsAll(expectedValue);
    }

    @Test
    void userUpdate_ValidationThrowException_WithInvalidRepeatedPassword() {
        UserUpdateFormData userUpdateFormData = validUserUpdate().repeatedPassword("notSamePass").build();
        Set<ConstraintViolation<UserUpdateFormData>> violations = validator.validate(userUpdateFormData);
        assertThat(violations)
            .hasSize(1);
    }
}
