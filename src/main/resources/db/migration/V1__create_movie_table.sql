CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE movie (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    overview TEXT NOT NULL,
    release_date DATE NOT NULL,
    tmdb_score DOUBLE PRECISION NOT NULL,
    poster_path VARCHAR(255),
    type VARCHAR(20) NOT NULL
);