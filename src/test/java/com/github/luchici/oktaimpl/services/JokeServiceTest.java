package com.github.luchici.oktaimpl.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.luchici.oktaimpl.Joke;
import com.github.luchici.oktaimpl.clients.JokeClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JokeService.class)
class JokeServiceTest {

    private static final int DEFAULT_JOKES_LIMIT = 1;
    @Autowired
    private JokeService underTest;
    @MockBean
    private JokeClient jokeClient;
    private Joke expectedJoke;

    @BeforeEach
    void setUp() {
        expectedJoke = new Joke("This is not a joke, this is a test!");
    }

    @Test
    void getJoke_ReturnNewJokeAsString() {
        // Given
        int minCharacterForJoke = 10;
        when(jokeClient.getJoke(DEFAULT_JOKES_LIMIT)).thenReturn(expectedJoke);
        // When
        String actualJoke = underTest.getJoke();
        // Then
        assertThat(actualJoke)
            .isNotNull()
            .isNotEmpty()
            .isNotBlank()
            .hasSizeGreaterThan(minCharacterForJoke);
    }

    @Test
    void getJoke_CallOnceJokeClient() {
        // Given
        int defaultJokesLimit = 1;
        // When
        when(jokeClient.getJoke(DEFAULT_JOKES_LIMIT)).thenReturn(expectedJoke);
        underTest.getJoke();
        // Then
        verify(jokeClient).getJoke(defaultJokesLimit);
    }
}