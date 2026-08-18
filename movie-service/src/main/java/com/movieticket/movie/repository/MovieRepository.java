package com.movieticket.movie.repository;

import com.movieticket.movie.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getAllMovies() {

        String sql = "SELECT id, name, language, genre FROM movies";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("language"),
                        rs.getString("genre")
                )
        );
    }

    public Movie getMovieById(int id) {

        String sql =
                "SELECT id, name, language, genre " +
                "FROM movies WHERE id = ?";

        List<Movie> movies = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("language"),
                        rs.getString("genre")
                ),
                id
        );

        if (movies.isEmpty()) {
            return null;
        }

        return movies.get(0);
    }

    public Movie addMovie(Movie movie) {

        String sql =
                "INSERT INTO movies (name, language, genre) " +
                "VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                movie.getName(),
                movie.getLanguage(),
                movie.getGenre()
        );

        return movie;
    }
}
