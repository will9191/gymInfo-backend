package com.example.gymInfo.exercise;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExerciseRequest {
    private Integer id;

    private String name;

    private String category;

    private String description;

    private String picture;
}
