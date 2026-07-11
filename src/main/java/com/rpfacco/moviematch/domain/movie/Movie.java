package com.rpfacco.moviematch.domain.movie;

import com.rpfacco.moviematch.domain.genre.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "movie")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String overview;
    private LocalDate releaseDate;
    private Double tmdbScore;
    private String posterPath;

    @Enumerated(EnumType.STRING)
    private MediaType type;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

}
