package com.example.gymInfo.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    List<Exercise> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);
}
