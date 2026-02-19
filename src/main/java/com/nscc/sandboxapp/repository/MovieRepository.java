package com.nscc.sandboxapp.repository;

import com.nscc.sandboxapp.entitiy.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// <Movie,Long>: indicates the Entity name and data type for the primary key

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // A function to get a Movie By Id AND include the related cast members
    @EntityGraph(attributePaths = {"castMembers"}) // tell system to populate the castMembers property in the Movie
    Optional<Movie> findMovieWithCastMembersById(Long id);
}
