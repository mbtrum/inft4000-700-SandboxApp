package com.nscc.sandboxapp.entitiy;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok adds getter and setter methods to code
@Entity
public class Movie {

    @Id // primary key in database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment id in database
    private Long id;

    @Column(nullable = false) // database validation
    private String title;

    @Column(nullable = false, length = 750) // database validation
    private String synopsis;
}
