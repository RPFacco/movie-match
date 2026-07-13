package com.rpfacco.moviematch.controller;

import com.rpfacco.moviematch.domain.recommendation.dto.MovieRecommendationRequestDTO;
import com.rpfacco.moviematch.domain.recommendation.dto.MovieRecommendationResponseDTO;
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
    public ResponseEntity<List<MovieRecommendationResponseDTO>> recommend(@RequestBody MovieRecommendationRequestDTO data) {
        return ResponseEntity.ok(movieRecommendationService.recommend(data));
    }

}
