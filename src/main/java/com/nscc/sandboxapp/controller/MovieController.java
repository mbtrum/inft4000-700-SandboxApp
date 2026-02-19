package com.nscc.sandboxapp.controller;

import com.nscc.sandboxapp.dto.CastMemberCreateDTO;
import com.nscc.sandboxapp.dto.MovieCreateDTO;
import com.nscc.sandboxapp.entitiy.CastMember;
import com.nscc.sandboxapp.entitiy.Movie;
import com.nscc.sandboxapp.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    /// ///////////////////////////////////////////////////
    // TO-DO: return a movie DTO instead of a movie Entity
    // ////////////////////////////////////////////////////

    // constructor
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // GET all movies - /movies
    @GetMapping("/")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // GET movie - /movies/5
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        // return the movie to throw an exception and return an HTTP 404.
        return movieService.getMovieById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // POST movie - /movies
    // @Valid: automatically validate input
    // @RequestBody: bind the POST request body to movieDTO
    @PostMapping("/")
    public Movie addMovie(@Valid @RequestBody MovieCreateDTO movieDTO) {
        // Use a DTO to receive input in API and plug into a movie object
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setSynopsis(movieDTO.getSynopsis());

        return movieService.createMovie(movie);
    }

    // POST ../movies/addcastmember
    @PostMapping("/addcastmember")
    public void addCastMember(@Valid @RequestBody CastMemberCreateDTO castMemberDTO) {
        // Use a DTO to receive input in API and plug into a cast member object
        CastMember castMember = new CastMember();
        castMember.setActorName(castMemberDTO.getActorName());
        castMember.setCharacterName(castMemberDTO.getCharacterName());
        // don't set movie_id, let the system do that

        long movieId = castMemberDTO.getMovieId();

        movieService.addCastMemberToMovie(movieId, castMember);
    }
}
