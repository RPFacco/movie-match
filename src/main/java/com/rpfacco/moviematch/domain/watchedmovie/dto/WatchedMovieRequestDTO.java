package com.rpfacco.moviematch.domain.watchedmovie.dto;

import java.time.LocalDate;

public record WatchedMovieRequestDTO(
        String title,
        Double rating,
        String review,
        LocalDate watchedAt,
        Boolean favorite
) {}