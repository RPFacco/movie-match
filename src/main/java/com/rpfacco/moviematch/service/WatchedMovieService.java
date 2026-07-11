package com.rpfacco.moviematch.service;

import com.rpfacco.moviematch.domain.watchedmovie.WatchedMovie;
import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieRequestDTO;
import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieResponseDTO;
import com.rpfacco.moviematch.repository.WatchedMovieRepository;
import org.springframework.stereotype.Service;

@Service
public class WatchedMovieService {

    private final WatchedMovieRepository repository;

    public WatchedMovieService(WatchedMovieRepository repository) {
        this.repository = repository;
    }

    public WatchedMovieResponseDTO createWatchedMovie(WatchedMovieRequestDTO data) {
        WatchedMovie newWatchedMovie = new WatchedMovie();
        newWatchedMovie.setTitle(data.title());
        newWatchedMovie.setRating(data.rating());
        newWatchedMovie.setReview(data.review());
        newWatchedMovie.setWatchedAt(data.watchedAt());
        newWatchedMovie.setFavorite(data.favorite());

        WatchedMovie savedWatchedMovie = repository.save(newWatchedMovie);

        return toResponseDTO(savedWatchedMovie);
    }

    private WatchedMovieResponseDTO toResponseDTO(WatchedMovie watchedMovie) {
        return new WatchedMovieResponseDTO(
                watchedMovie.getId(),
                watchedMovie.getTitle(),
                watchedMovie.getRating(),
                watchedMovie.getReview(),
                watchedMovie.getWatchedAt(),
                watchedMovie.getFavorite()

        );
    }

}
