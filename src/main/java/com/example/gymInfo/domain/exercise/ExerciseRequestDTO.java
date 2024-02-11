package com.example.gymInfo.domain.exercise;

import jakarta.validation.constraints.NotBlank;

public record ExerciseRequestDTO(
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
