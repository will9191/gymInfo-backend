package com.example.gymInfo.exercise;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class ExerciseRequest {
    private Integer id;

    private String name;
    private String category;

    private String[] primaryMuscle;

    private String[] secondaryMuscles;

    private String equipment;

    private String description;

    private String picture;
}
