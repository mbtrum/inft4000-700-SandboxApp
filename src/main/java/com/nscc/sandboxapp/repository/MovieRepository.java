package com.nscc.sandboxapp.repository;

import com.nscc.sandboxapp.entitiy.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

// <Movie,Long>: indicates the Entity name and data type for the primary key

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
