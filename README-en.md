# movie-match

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-6DB33F?logo=springsecurity)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?logo=postgresql)
![Flyway](https://img.shields.io/badge/Flyway-Migrations-CC0200?logo=flyway)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?logo=swagger)

API built in Java with Spring Boot. Users can request movie and TV show recommendations, fetching data from TMDB (The Movie Database) based on a specified genre and minimum rating, as well as manage their watched movies/shows through a CRUD.

## Key Takeaways

This project was built as a learning exercise, focused on building a REST API with Spring Boot. Throughout development, concepts such as dependency injection, layered architecture, relationship modeling with JPA, schema versioning with Flyway, and authentication/authorization with Spring Security and JWT were explored.

Regarding my personal experience, at the start I focused on understanding why and how each Spring Boot layer related to the others. Once I understood the Controller → Service → Repository flow and the Spring Boot annotations, I was able to keep developing with more autonomy. I realized this framework requires a lot of hands-on practice to be truly understood, and this project helped a lot with that process.

## Features

- User registration and login with JWT authentication
- CRUD for watched movies/shows (create, list, edit, remove)
- Movie recommendations by genre and minimum rating, via the TMDB API
- Each user can only access and modify their own records

## Stack

- Java
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Flyway
- springdoc-openapi (Swagger)

## Usage Example

Request and response for the recommendation endpoint, filtering by genre and minimum rating.

![Recommendation example](images/exemplo.png)

## Running Locally

### Prerequisites

- Java 21
- PostgreSQL running locally
- A [TMDB](https://www.themoviedb.org/documentation/api) API key

### Environment Variables

```
DB_URL=jdbc:postgresql://localhost:5432/moviematch
DB_USERNAME=your_username
DB_PASSWORD=your_password
TMDB_API_KEY=your_tmdb_read_access_token
JWT_SECRET=a_secret_key
```

### Running

With the database created and the environment variables set, Flyway migrations run automatically on startup:

```bash
./mvnw spring-boot:run
```

The application runs on `http://localhost:8080`.

## API Documentation

With the application running, the interactive documentation is available at:

```
http://localhost:8080/swagger-ui/index.html
```

Public routes: registration (`/users`), login (`/auth/login`), and recommendations (`/movies/recommendations`). Everything else requires a valid JWT token in the `Authorization: Bearer <token>` header.