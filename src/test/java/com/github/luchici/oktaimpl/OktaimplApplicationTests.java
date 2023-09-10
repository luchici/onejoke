package com.github.luchici.oktaimpl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class OktaimplApplicationTests {

    @Test
    void contextLoads(WebApplicationContext context) {
        assertThat(context)
            .isNotNull();
    }
}
