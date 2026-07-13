package com.rpfacco.moviematch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class TmdbConfig {

    @Value("${tmdb.access-token}")
    private String accessToken;

    @Value("${tmdb.base-url}")
    private String baseUrl;

    @Bean
    public RestClient tmdbRestClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + accessToken)
                .build();
    }

}
