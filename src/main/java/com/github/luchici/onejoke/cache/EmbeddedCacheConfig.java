package com.github.luchici.onejoke.cache;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
// @EnableCaching
public class EmbeddedCacheConfig {

    //  TODO:  Do it as a yaml file
    // @Bean
    Config config() {
        Config config = new Config();
        MapConfig mapConfig = new MapConfig();

        mapConfig.setTimeToLiveSeconds(20);
        config.getMapConfigs().put("jokes", mapConfig);

        return config;
    }
}
