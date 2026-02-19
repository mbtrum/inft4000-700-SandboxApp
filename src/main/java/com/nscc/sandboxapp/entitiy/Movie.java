package com.nscc.sandboxapp.entitiy;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    // one-to-many relationship to Cast Member
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CastMember> castMembers = new ArrayList<>();

    //
    // Helper methods
    //

    public void addCastMember(CastMember castMember) {
        castMembers.add(castMember);
        castMember.setMovie(this); // set the parent Movie entity for this new cast member
    }
}
