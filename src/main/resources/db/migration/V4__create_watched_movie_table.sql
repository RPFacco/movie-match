CREATE TABLE watched_movie (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    rating DOUBLE PRECISION,
    review TEXT,
    watched_at DATE NOT NULL,
    favorite BOOLEAN NOT NULL DEFAULT FALSE,
    user_id UUID NOT NULL REFERENCES users(id)
);