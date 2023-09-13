package com.github.luchici.onejoke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class OneJokeApplicationTests {

    @Test
    void contextLoads(WebApplicationContext context) {
        assertThat(context)
            .isNotNull();
    }
}
