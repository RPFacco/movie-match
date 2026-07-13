package com.rpfacco.moviematch.controller;

import com.rpfacco.moviematch.domain.movie.dto.MovieRequestDTO;
import com.rpfacco.moviematch.domain.movie.dto.MovieResponseDTO;
import com.rpfacco.moviematch.service.MovieRecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies/recommendations")
public class MovieRecommendationController {

    private final MovieRecommendationService movieRecommendationService;

    public MovieRecommendationController(MovieRecommendationService movieRecommendationService) {
        this.movieRecommendationService = movieRecommendationService;
    }

    @PostMapping
    public ResponseEntity<List<MovieResponseDTO>> recommend(@RequestBody MovieRequestDTO data) {
        return ResponseEntity.ok(movieRecommendationService.recommend(data));
    }

}
