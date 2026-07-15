package com.rpfacco.moviematch.client;

import java.util.Arrays;

public enum TmdbGenre {
    ACTION(28, "Ação"),
    ADVENTURE(12, "Aventura"),
    ANIMATION(16, "Animação"),
    COMEDY(35, "Comédia"),
    CRIME(80, "Crime"),
    DOCUMENTARY(99, "Documentário"),
    DRAMA(18, "Drama"),
    FAMILY(10751, "Família"),
    FANTASY(14, "Fantasia"),
    HISTORY(36, "História"),
    HORROR(27, "Terror"),
    MUSIC(10402, "Música"),
    MYSTERY(9648, "Mistério"),
    ROMANCE(10749, "Romance"),
    SCIENCE_FICTION(878, "Ficção científica"),
    TV_MOVIE(10770, "Cinema TV"),
    THRILLER(53, "Thriller"),
    WAR(10752, "Guerra"),
    WESTERN(37, "Faroeste");

    private final long tmdbId;
    private final String displayName;

    TmdbGenre(long tmdbId, String displayName) {
        this.tmdbId = tmdbId;
        this.displayName = displayName;
    }

    public static String nameFor(long tmdbId) {
        return Arrays.stream(values())
                .filter(genre -> genre.tmdbId == tmdbId)
                .map(genre -> genre.displayName)
                .findFirst()
                .orElse("Desconhecido");
    }

    public long getTmdbId() {
        return tmdbId;
    }
}