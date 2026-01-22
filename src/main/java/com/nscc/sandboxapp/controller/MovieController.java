package com.nscc.sandboxapp.controller;

import com.nscc.sandboxapp.entitiy.Movie;
import com.nscc.sandboxapp.service.MovieService;
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
    @PostMapping("/")
    public String AddMovie() {
        return "Success, movie added.";
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
