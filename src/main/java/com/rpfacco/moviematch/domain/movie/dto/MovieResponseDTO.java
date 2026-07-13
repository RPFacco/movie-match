package com.rpfacco.moviematch.domain.movie.dto;

import java.time.LocalDate;
import java.util.List;

public record MovieResponseDTO(
        Long tmdbId,
        String title,
        String overview,
        LocalDate releaseDate,
        Double tmdbScore,
        String posterPath,
        List<Long> genreIds
) {}