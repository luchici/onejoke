package com.github.luchici.onejoke.controllers;

import static com.github.luchici.onejoke.validation.updateUser.UserUpdateFormDataValidationUtility.validUserUpdate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static com.github.luchici.onejoke.utility.OneJokeUtility.rethrowCheckedException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.luchici.onejoke.config.GeneralConfig;
import com.github.luchici.onejoke.config.ThymeleafConfig;
import com.github.luchici.onejoke.model.UserUpdateFormData;
import com.github.luchici.onejoke.services.JokeService;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(JokeController.class)
@Import({ThymeleafConfig.class, GeneralConfig.class})
public class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private JokeService jokeService;
    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @ValueSource(strings = {"/", "/home"})
    void getHome_ReturnsHomeViewWithNoJoke(String path) throws Exception {
        // Given

        // When
        mockMvc.perform(get(path))
            // Then
            .andExpectAll(
                status().isOk(),
                view().name("home"),
                content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
    }

    @Test
    void validUserUpdate_ReturnProfileWithoutAnyValidationErrors() throws Exception {
        // Given
        UserUpdateFormData validUserUpdateFormData = validUserUpdate().build();
        // When
        mockMvc.perform(profilePostRequest(validUserUpdateFormData))
            // Then
            .andExpectAll(
                status().isOk(),
                view().name("profile"),
                content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"),
                content().string(containsString("Successful Update")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"firstName", "lastName", "username", "dob", "email", "password", "repeatedPassword"})
    void invalidUpdateUserSubmit_ReturnProfileWithValidationErrors(String invalidField) throws Exception {
        // Given
        UserUpdateFormData invalidUserUpdateFormData = getInvalidUserUpdate(invalidField);
        System.out.println("invalidUserUpdate = " + invalidUserUpdateFormData);
        // When
        mockMvc.perform(get("/profile"))
            // Then
            .andExpectAll(
                status().isOk(),
                view().name("profile"),
                content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8")
            );
        
    }

    private UserUpdateFormData getInvalidUserUpdate(String invalidField) {
        String invalidValue = null;
        UserUpdateFormData.UserUpdateFormDataBuilder userUpdate = validUserUpdate();
        Arrays.stream(userUpdate.getClass().getMethods())
            .filter(method -> method.getName().equals(invalidField))
            .forEach(rethrowCheckedException(method -> method.invoke(userUpdate, invalidValue)));
        return userUpdate.build();
    }

    private RequestBuilder profilePostRequest(UserUpdateFormData defaultUserUpdateFormData) {
        return MockMvcRequestBuilders.post("/profile")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("firstName", defaultUserUpdateFormData.getFirstName())
            .param("lastName", defaultUserUpdateFormData.getLastName())
            .param("username", defaultUserUpdateFormData.getUsername())
            .param("dob", defaultUserUpdateFormData.getDob().toString())
            .param("email", defaultUserUpdateFormData.getEmail())
            .param("password", defaultUserUpdateFormData.getPassword())
            .param("repeatedPassword", defaultUserUpdateFormData.getRepeatedPassword());
    }
}
