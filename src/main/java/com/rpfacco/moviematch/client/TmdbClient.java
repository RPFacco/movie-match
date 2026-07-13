package com.rpfacco.moviematch.client;

import com.rpfacco.moviematch.client.dto.TmdbDiscoverResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TmdbClient {

    private final RestClient tmdbRestClient;

    public TmdbClient(RestClient tmdbRestClient) {
        this.tmdbRestClient = tmdbRestClient;
    }

    public TmdbDiscoverResponseDTO discoverMovies(List<Long> genreIds, Double minScore) {
        String genres = genreIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return tmdbRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/discover/movie")
                        .queryParam("with_genres", genres)
                        .queryParam("vote_average.gte", minScore)
                        .build())
                .retrieve()
                .body(TmdbDiscoverResponseDTO.class);
    }

}
