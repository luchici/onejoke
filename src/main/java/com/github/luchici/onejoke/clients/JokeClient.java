package com.github.luchici.onejoke.clients;

import com.github.luchici.onejoke.Joke;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "joke-client", url = "https://api.api-ninjas.com/v1", configuration = FeignConfig.class)
public interface JokeClient {

    @GetMapping(value = "/jokes")
    Joke getJoke(@RequestParam(value = "limit") int limit);
}
