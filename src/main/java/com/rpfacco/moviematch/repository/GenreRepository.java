package com.rpfacco.moviematch.repository;

import com.rpfacco.moviematch.domain.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
}
