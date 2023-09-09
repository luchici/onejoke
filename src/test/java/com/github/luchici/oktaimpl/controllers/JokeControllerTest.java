package com.github.luchici.oktaimpl.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(JokeController.class)
public class JokeControllerTest {

    private final String rootURL = "/jokes";
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getJoke_ReturnsJokeAsString() throws Exception {
        // Given
        String expectedViewName = "joke";
        // When
        mockMvc.perform(get(rootURL + "/just-one"))
        // Then
                    .andExpect(
                        view().name(expectedViewName));
    }
}
