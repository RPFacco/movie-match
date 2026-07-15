package com.rpfacco.moviematch.domain.recommendation.dto;

import com.rpfacco.moviematch.client.TmdbGenre;

import java.util.List;

public record MovieRecommendationRequestDTO(
        List<TmdbGenre> genres,
        Double minScore
) {}