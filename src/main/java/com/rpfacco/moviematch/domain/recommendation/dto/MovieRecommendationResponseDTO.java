package com.rpfacco.moviematch.domain.recommendation.dto;

import java.time.LocalDate;
import java.util.List;

public record MovieRecommendationResponseDTO(
        Long tmdbId,
        String title,
        String overview,
        LocalDate releaseDate,
        Double tmdbScore,
        String posterPath,
        List<Long> genreIds
) {}