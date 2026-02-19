package com.nscc.sandboxapp.service;

import com.nscc.sandboxapp.entitiy.CastMember;
import com.nscc.sandboxapp.entitiy.Movie;
import com.nscc.sandboxapp.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    // dependency injection.
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMovieWithCastMembers(Long id) {
        return movieRepository.findMovieWithCastMembersById(id);
    }

    @Override
    public Movie addCastMemberToMovie(Long movieId, CastMember castMember) {
        // Find movie
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        movie.addCastMember(castMember);

        return movieRepository.save(movie); // this will update the Movie AND add the cast member in the Db
    }
}
