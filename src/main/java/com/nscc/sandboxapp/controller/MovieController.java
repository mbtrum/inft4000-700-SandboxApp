package com.nscc.sandboxapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    // constructor
    public MovieController() {
    }

    // GET all movies - /movies
    @GetMapping("/")
    public String getAllMovies() {
        return "Get all movies";
    }

    // GET movie - /movies/5
    @GetMapping("/{id}")
    public String getMovieById(@PathVariable int id) {
        return "Get a movie by id: " + id;
    }

//    // POST movie - /movies
//    @PostMapping("/")
//    public String AddMovie() {
//        return "Success, movie added.";
//    }
//
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
