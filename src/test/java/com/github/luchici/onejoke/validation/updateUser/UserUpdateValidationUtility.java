package com.github.luchici.onejoke.validation.updateUser;

import com.github.luchici.onejoke.model.UserUpdateFormData;
import com.github.luchici.onejoke.model.UserUpdateFormData.UserUpdateFormDataBuilder;
import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class UserUpdateValidationUtility {
    private static UserUpdateFormData.UserUpdateFormDataBuilder defaultUserUpdate;

    public static Stream<Arguments> provideUsersWithInvalidFirstname() {
        defaultUserUpdate = validUserUpdate();
        return Stream.of(
            Arguments.of(defaultUserUpdate.firstName("    ").build()),                        // blank
            Arguments.of(defaultUserUpdate.firstName(null).build()),                          // null
            Arguments.of(defaultUserUpdate.firstName("").build()),                            // empty
            Arguments.of(defaultUserUpdate.firstName("Io").build()),                          // to short
            Arguments.of(defaultUserUpdate.firstName("Iosadasdasdasdfdhvxc123@@").build()),   // to long
            Arguments.of(defaultUserUpdate.firstName("Ion123").build()),                      // no symbol
            Arguments.of(defaultUserUpdate.firstName("ion123@@").build()),                    // no uppercase
            Arguments.of(defaultUserUpdate.firstName("ION123@@").build()),                    // no lower case
            Arguments.of(defaultUserUpdate.firstName("Ion@@").build()),                       // no digit
            Arguments.of(defaultUserUpdate.firstName("Ion 123").build()),                     // contain space
            Arguments.of(defaultUserUpdate.firstName("Ion   123").build()),                   // contain tab
            Arguments.of(defaultUserUpdate.firstName("Ion$$").build()));                      // no digit
    }

    public static Stream<Arguments> provideUsersWithInvalidLastname() {
        defaultUserUpdate = validUserUpdate();
        return Stream.of(
            Arguments.of(defaultUserUpdate.lastName("    ").build()),                         // blank
            Arguments.of(defaultUserUpdate.lastName(null).build()),                          // null
            Arguments.of(defaultUserUpdate.lastName("").build()),                            // empty
            Arguments.of(defaultUserUpdate.lastName("Io").build()),                          // to short
            Arguments.of(defaultUserUpdate.lastName("Iosadasdasdasdfdhvxc123@@").build()),   // to long
            Arguments.of(defaultUserUpdate.lastName("Ion123").build()),                      // no symbol
            Arguments.of(defaultUserUpdate.lastName("ion123@@").build()),                    // no uppercase
            Arguments.of(defaultUserUpdate.lastName("ION123@@").build()),                    // no lower case
            Arguments.of(defaultUserUpdate.lastName("Ion@@").build()),                       // no digit
            Arguments.of(defaultUserUpdate.lastName("Ion 123").build()),                     // contain space
            Arguments.of(defaultUserUpdate.lastName("Ion   123").build()),                   // contain tab
            Arguments.of(defaultUserUpdate.lastName("Ion$$").build()));                      // no digit
    }

    public static Stream<Arguments> provideUsersWithInvalidUsername() {
        defaultUserUpdate = validUserUpdate();
        return Stream.of(
            Arguments.of(defaultUserUpdate.username("    ").build()),                        // blank
            Arguments.of(defaultUserUpdate.username(null).build()),                          // null
            Arguments.of(defaultUserUpdate.username("").build()),                            // empty
            Arguments.of(defaultUserUpdate.username("Io").build()),                          // to short
            Arguments.of(defaultUserUpdate.username("Iosadasdasdasdfdhvxc123@@").build()),   // to long
            Arguments.of(defaultUserUpdate.username("Ion 123").build()),                     // contain space
            Arguments.of(defaultUserUpdate.username("Ion   123").build()));                  // contain tab
    }

    public static Stream<Arguments> provideUsersWithInvalidLocalDate() {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = LocalDate.now().plusDays(7);
        defaultUserUpdate = validUserUpdate();
        return Stream.of(
            Arguments.of(defaultUserUpdate.dob(null).build()),
            Arguments.of(defaultUserUpdate.dob(today).build()),
            Arguments.of(defaultUserUpdate.dob(futureDate).build()));
    }

    public static Stream<Arguments> provideUsersWithInvalidEmail() {
        defaultUserUpdate = validUserUpdate();
        return Stream.of(
            Arguments.of(defaultUserUpdate.email("    ").build()),                        // blank
            Arguments.of(defaultUserUpdate.email(null).build()),                          // null
            Arguments.of(defaultUserUpdate.email("").build()),                            // empty
            Arguments.of(defaultUserUpdate.email("someEmail@").build()),
            Arguments.of(defaultUserUpdate.email("someEmail@.com").build()),
            Arguments.of(defaultUserUpdate.email("@host.com").build()));
    }

    public static Stream<Arguments> provideUsersWithInvalidPassword() {
        defaultUserUpdate = validUserUpdate();
        return Stream.of(
            Arguments.of(defaultUserUpdate
                            .password("    ")
                            .repeatedPassword("    ")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password(null)
                            .repeatedPassword(null)
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("")
                            .repeatedPassword("")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("pass")
                            .repeatedPassword("pass")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("pass01234567890123456789")
                            .repeatedPassword("pass01234567890123456789")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("somePass@@")
                            .repeatedPassword("somePass@@")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("SOMEPASS22@@")
                            .repeatedPassword("SOMEPASS22@@")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("somepass22@@")
                            .repeatedPassword("somepass22@@")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("somePass22")
                            .repeatedPassword("somePass22")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("somePass  22@@")
                            .repeatedPassword("somePass  22@@")
                            .build()),
            Arguments.of(defaultUserUpdate
                            .password("somePass   22@@")
                            .repeatedPassword("somePass   22@@")
                            .build()));
    }

    public static UserUpdateFormDataBuilder validUserUpdate() {
        return UserUpdateFormData.builder()
            .firstName("Brad")
            .lastName("Pitt")
            .username("bradPitt")
            .dob(LocalDate.of(1963, 12, 18))
            .email("bradPitt@gmail.com")
            .password("somePass22@@")
            .repeatedPassword("somePass22@@");
    }
}
