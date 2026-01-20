package com.nscc.sandboxapp.service;

import com.nscc.sandboxapp.entitiy.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(Long id); // optional = nullable

    Movie createMovie(Movie movie);
}
