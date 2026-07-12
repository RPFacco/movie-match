package com.rpfacco.moviematch.controller;

import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieRequestDTO;
import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieResponseDTO;
import com.rpfacco.moviematch.service.WatchedMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/watched-movies")
public class WatchedMovieController {

    private final WatchedMovieService watchedMovieService;

    public WatchedMovieController(WatchedMovieService watchedMovieService) {
        this.watchedMovieService = watchedMovieService;
    }

    @PostMapping
    public ResponseEntity<WatchedMovieResponseDTO> create(
            @RequestBody WatchedMovieRequestDTO data,
            @RequestParam UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(watchedMovieService.createWatchedMovie(data, userId));
    }

    @GetMapping
    public ResponseEntity<List<WatchedMovieResponseDTO>> findAll(@RequestParam UUID userId) {
        return ResponseEntity.ok(watchedMovieService.findAllWatchedMoviesByUser(userId));
    }

}
