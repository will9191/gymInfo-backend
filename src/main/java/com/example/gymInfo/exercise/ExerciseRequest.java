package com.example.gymInfo.exercise;

import jakarta.validation.constraints.NotBlank;

public record ExerciseRequest(
        String id,
        @NotBlank
        String name,
        @NotBlank
        String category,
        @NotBlank
        String description,
        @NotBlank
        String picture
) {

}
