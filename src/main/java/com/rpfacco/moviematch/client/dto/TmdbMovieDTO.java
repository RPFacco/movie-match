package com.rpfacco.moviematch.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TmdbMovieDTO(
        Long id,
        String title,
        String overview,
        @JsonProperty("release_date") String releaseDate,
        @JsonProperty("vote_average") Double voteAverage,
        @JsonProperty("poster_path") String posterPath,
        @JsonProperty("genre_ids") List<Long> genreIds
) {}
