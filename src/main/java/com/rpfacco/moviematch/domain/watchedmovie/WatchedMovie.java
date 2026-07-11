package com.rpfacco.moviematch.domain.watchedmovie;

import com.rpfacco.moviematch.domain.movie.Movie;
import com.rpfacco.moviematch.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "watched_movie")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WatchedMovie {

    @Id
    @GeneratedValue
    private UUID id;

    private Double rating;
    private String review;
    private LocalDate watchedAt;
    private Boolean favorite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
