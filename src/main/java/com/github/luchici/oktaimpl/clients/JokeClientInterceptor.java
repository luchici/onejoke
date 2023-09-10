package com.github.luchici.oktaimpl.clients;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api-key.properties")
public class JokeClientInterceptor implements RequestInterceptor {

    @Value("${jokes.api}")
    private String apiKey;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Api-Key", apiKey);
    }
}
