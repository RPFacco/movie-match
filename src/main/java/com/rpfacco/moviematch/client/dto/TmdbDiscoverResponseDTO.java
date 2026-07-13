package com.rpfacco.moviematch.client.dto;

import java.util.List;

public record TmdbDiscoverResponseDTO(
        List<TmdbMovieDTO> results
) {}
