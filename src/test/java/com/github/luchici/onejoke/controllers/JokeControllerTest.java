package com.github.luchici.onejoke.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.github.luchici.onejoke.ThymeleafConfig;
import com.github.luchici.onejoke.services.JokeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(JokeController.class)
@Import({ThymeleafConfig.class})
public class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private JokeService jokeService;

    @ParameterizedTest
    @ValueSource(strings = {"/", "/home"})
    void getHome_ReturnsHomeView(String path) throws Exception {
        // Given

        // When
        mockMvc.perform(get(path))
            // Then
            .andExpectAll(
                status().isOk(),
                view().name("home"),
                content().contentType(MediaType.TEXT_HTML_VALUE+";charset=UTF-8"));
    }
}
