package com.rpfacco.moviematch.domain.recommendation.dto;

import java.util.List;

public record MovieRecommendationRequestDTO(
        List<Long> genreIds,
        Double minScore
) {}