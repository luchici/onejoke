package com.github.luchici.onejoke.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.github.luchici.onejoke.services.JokeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(JokeController.class)
public class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private JokeService jokeService;

    @Test
    void getHome_ReturnsHomeView() throws Exception {
        // Given
        String expectedViewName = "home";
        // When
        mockMvc.perform(get("/"))
        // Then
                    .andExpect(
                        view().name(expectedViewName));
    }
}
