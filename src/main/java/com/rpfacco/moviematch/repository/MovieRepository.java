package com.rpfacco.moviematch.repository;

import com.rpfacco.moviematch.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
