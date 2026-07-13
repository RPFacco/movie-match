package com.rpfacco.moviematch.domain.movie.dto;

import java.util.List;

public record MovieRequestDTO(
        List<Long> genreIds,
        Double minScore
) {}