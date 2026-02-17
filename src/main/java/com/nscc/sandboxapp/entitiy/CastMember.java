package com.nscc.sandboxapp.entitiy;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok adds getter and setter methods to code
@Entity
public class CastMember {

    @Id // primary key in database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment id in database
    private Long id;

    @Column(nullable = false)
    private String actorName;

    @Column(nullable = false)
    private String characterName;

    // one-to-many relationship to Movie
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
