package com.nscc.sandboxapp.controller;

import com.nscc.sandboxapp.dto.MovieCreateDTO;
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
    @ResponseStatus(HttpStatus.CREATED) // HTTP Status Code: 201
    public Movie CreateMovie(@Valid @RequestBody MovieCreateDTO movieDTO) {
        // Use a DTO to receive input in API and plug into a movie object
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setSynopsis(movieDTO.getSynopsis());

        return movieService.createMovie(movie);
    }

//    // DELETE movie - /movies
//    @DeleteMapping("/{id}")
//    public String DeleteMovieById(@PathVariable int id) {
//        return "Success, movie deleted for id: " + id;
//    }
//
//    // PUT movie - /movies
//    @PutMapping("/")
//    public String UpdateMovie() {
//        return "Success, movie updated.";
//    }


}
