package com.rpfacco.moviematch.service;

import com.rpfacco.moviematch.domain.user.User;
import com.rpfacco.moviematch.domain.watchedmovie.WatchedMovie;
import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieRequestDTO;
import com.rpfacco.moviematch.domain.watchedmovie.dto.WatchedMovieResponseDTO;
import com.rpfacco.moviematch.repository.UserRepository;
import com.rpfacco.moviematch.repository.WatchedMovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WatchedMovieService {

    private final WatchedMovieRepository watchedMovieRepository;
    private final UserRepository userRepository;

    public WatchedMovieService(WatchedMovieRepository watchedMovieRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.watchedMovieRepository = watchedMovieRepository;
    }

    public WatchedMovieResponseDTO createWatchedMovie(WatchedMovieRequestDTO data, UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));

        WatchedMovie newWatchedMovie = new WatchedMovie();
        newWatchedMovie.setUser(user);
        applyData(newWatchedMovie, data);

        WatchedMovie savedWatchedMovie = watchedMovieRepository.save(newWatchedMovie);
        return toResponseDTO(savedWatchedMovie);
    }

    public List<WatchedMovieResponseDTO> findAllWatchedMoviesByUser(UUID userId) {
        return watchedMovieRepository.findAllByUserId(userId).stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public WatchedMovieResponseDTO updateWatchedMovie(WatchedMovieRequestDTO data, UUID id, UUID userId) {
        WatchedMovie watchedMovie = watchedMovieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme assistido nao encontrado"));

        validateOwnership(watchedMovie, userId);

        applyData(watchedMovie, data);

        WatchedMovie updatedWatchedMovie = watchedMovieRepository.save(watchedMovie);
        return toResponseDTO(updatedWatchedMovie);
    }

    public void deleteWatchedMovie(UUID id, UUID userId) {
        WatchedMovie watchedMovie = watchedMovieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme assistido nao encontrado"));

        validateOwnership(watchedMovie, userId);

        watchedMovieRepository.deleteById(id);
    }

    private void validateOwnership(WatchedMovie watchedMovie, UUID userId) {
        if (!watchedMovie.getUser().getId().equals(userId)) {
            throw new AccessDeniedException("Voce nao tem permissao para acessar este recurso");
        }
    }

    private void applyData(WatchedMovie watchedMovie, WatchedMovieRequestDTO data) {
        watchedMovie.setTitle(data.title());
        watchedMovie.setRating(data.rating());
        watchedMovie.setReview(data.review());
        watchedMovie.setWatchedAt(data.watchedAt());
        watchedMovie.setFavorite(data.favorite());
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
