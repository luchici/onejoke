package com.github.luchici.onejoke.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.luchici.onejoke.model.Joke;
import feign.Response;
import feign.codec.Decoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JokeClientDecoder implements Decoder {

    private final ObjectMapper objectMapper;
    @Override
    public Joke decode(Response response, Type type) throws IOException {
        String body = new BufferedReader(
                            new InputStreamReader(response.body().asInputStream(), StandardCharsets.UTF_8))
                        .readLine();
        List<Joke> jokes = objectMapper.readValue(body, new TypeReference<>() {});
        return jokes.get(0);
    }
}
