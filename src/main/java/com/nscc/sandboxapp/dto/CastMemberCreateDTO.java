package com.nscc.sandboxapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CastMemberCreateDTO {
    @NotBlank(message = "Actor name is required.")
    private String actorName;

    @NotBlank(message = "Character name is required.")
    private String characterName;

    @NotNull(message = "Movie Id is required.")
    private int movieId; // foreign key

    // no id
}
