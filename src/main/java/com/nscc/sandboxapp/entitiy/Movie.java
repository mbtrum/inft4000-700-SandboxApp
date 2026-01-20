package com.nscc.sandboxapp.entitiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data // Lombok adds getter and setter methods to code
@Entity
public class Movie {

    @Id // primary key in database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment id in database
    private Long id;

    @NotBlank(message = "Title is required.") // controller validation
    @Column(nullable = false) // database validation
    private String title;

    @NotBlank(message = "Synopsis is required.")
    @Column(nullable = false, length = 750)
    private String synopsis;

    @NotBlank(message = "Runtime is required.")
    @Column(nullable = false)
    private int runtime;
}
