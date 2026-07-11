package com.rpfacco.moviematch.repository;

import com.rpfacco.moviematch.domain.watchedmovie.WatchedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WatchedMovieRepository extends JpaRepository<WatchedMovie, UUID> {
}
