package com.example.gymInfo.exercise;

public record ExerciseResponseDTO(String id, String name, String category, String description, String picture) {
    public ExerciseResponseDTO(Exercise exercise) {
        this(exercise.getId(), exercise.getName(), exercise.getCategory(), exercise.getDescription(), exercise.getPicture());
    }
}
