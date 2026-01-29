package com.nscc.sandboxapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Common bean validations: @NotNull, @NotEmpty, @NotBlank, @Size, @Min, @Max, @Email, and @Pattern

// DTOs Data Transfer Objects are used to transfer data between layers in app, helping to prevent errors or malicious attacks.
@Data
public class MovieCreateDTO {

    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Synopsis is required.")
    @Size(max=750)
    private String synopsis;

    // no ID field - this is generated in the database, not as incoming input
}
