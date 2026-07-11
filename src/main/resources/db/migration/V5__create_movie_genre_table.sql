CREATE TABLE movie_genre (
    movie_id UUID NOT NULL REFERENCES movie(id),
    genre_id UUID NOT NULL REFERENCES genre(id),
    PRIMARY KEY (movie_id, genre_id)
);