package com.rpfacco.moviematch.service;

import com.rpfacco.moviematch.client.TmdbClient;
import com.rpfacco.moviematch.client.dto.TmdbDiscoverResponseDTO;
import com.rpfacco.moviematch.client.dto.TmdbMovieDTO;
import com.rpfacco.moviematch.domain.recommendation.dto.MovieRecommendationRequestDTO;
import com.rpfacco.moviematch.domain.recommendation.dto.MovieRecommendationResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieRecommendationService {

    private final TmdbClient tmdbClient;

    public MovieRecommendationService(TmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }

    public List<MovieRecommendationResponseDTO> recommend(MovieRecommendationRequestDTO data) {
        TmdbDiscoverResponseDTO tmdbResponse = tmdbClient.discoverMovies(data.genreIds(), data.minScore());

        return tmdbResponse.results().stream()
                .map(this::toMovieRecommendationResponseDTO)
                .toList();
    }

    private MovieRecommendationResponseDTO toMovieRecommendationResponseDTO(TmdbMovieDTO tmdbMovie) {
        return new MovieRecommendationResponseDTO(
                tmdbMovie.id(),
                tmdbMovie.title(),
                tmdbMovie.overview(),
                (tmdbMovie.releaseDate() == null || tmdbMovie.releaseDate().isBlank())
                        ? null
                        : LocalDate.parse(tmdbMovie.releaseDate()),
                tmdbMovie.voteAverage(),
                tmdbMovie.posterPath(),
                tmdbMovie.genreIds()
        );
    }
}
