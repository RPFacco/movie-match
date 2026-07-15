package com.rpfacco.moviematch.controller;

import com.rpfacco.moviematch.domain.user.User;
import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieRequestDTO;
import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieResponseDTO;
import com.rpfacco.moviematch.service.WatchedMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            @AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(watchedMovieService.createWatchedMovie(data, user.getId()));
    }

    @GetMapping
    public ResponseEntity<List<WatchedMovieResponseDTO>> findAll(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(watchedMovieService.findAllWatchedMoviesByUser(user.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WatchedMovieResponseDTO> update(
            @RequestBody WatchedMovieRequestDTO data,
            @PathVariable UUID id,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(watchedMovieService.updateWatchedMovie(data, id, user.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id, @AuthenticationPrincipal User user) {
        watchedMovieService.deleteWatchedMovie(id, user.getId());
        return ResponseEntity.noContent().build();
    }
}