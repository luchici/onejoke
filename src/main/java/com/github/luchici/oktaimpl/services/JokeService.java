package com.github.luchici.oktaimpl.services;

import com.github.luchici.oktaimpl.Joke;
import com.github.luchici.oktaimpl.clients.JokeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JokeService {

    private static final int DEFAULT_JOKES_LIMIT = 1;
    private final JokeClient jokeClient;


    public String getJoke(){
        Joke joke = jokeClient.getJoke(DEFAULT_JOKES_LIMIT);
        return joke.getJokeText();
    }
}
