package com.rpfacco.moviematch.domain.watchedmovie.dto;

import java.time.LocalDate;
import java.util.UUID;

public record WatchedMovieResponseDTO(
        UUID id,
        String title,
        Double rating,
        String review,
        LocalDate watchedAt,
        Boolean favorite
) {}
