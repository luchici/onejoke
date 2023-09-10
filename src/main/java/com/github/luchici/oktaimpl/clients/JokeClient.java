package com.github.luchici.oktaimpl.clients;

import com.github.luchici.oktaimpl.Joke;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "joke-client", url = "https://api.api-ninjas.com/v1")
public interface JokeClient {

    @GetMapping(value = "/jokes")
    Joke getJoke(@RequestParam(value = "limit") int limit);
}
