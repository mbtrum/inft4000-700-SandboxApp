package com.nscc.sandboxapp.service;

import com.nscc.sandboxapp.entitiy.CastMember;
import com.nscc.sandboxapp.entitiy.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(Long id); // optional = nullable

    Movie createMovie(Movie movie);

    Optional<Movie> getMovieWithCastMembers(Long id);

    Movie addCastMemberToMovie(Long movieId, CastMember castMember);

}
