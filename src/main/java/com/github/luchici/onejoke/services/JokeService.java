package com.github.luchici.onejoke.services;

import com.github.luchici.onejoke.Joke;
import com.github.luchici.onejoke.clients.JokeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JokeService {

    private static final int DEFAULT_JOKES_LIMIT = 1;
    private final JokeClient jokeClient;


    @Cacheable(value = "jokes")
    public String getJoke(){
        Joke joke = jokeClient.getJoke(DEFAULT_JOKES_LIMIT);
        return joke.getJokeText();
    }
}
