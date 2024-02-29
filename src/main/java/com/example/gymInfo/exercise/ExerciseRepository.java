package com.example.gymInfo.exercise;

import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
//   @Query(value = "SELECT e FROM Exercise e WHERE (:name is null or e.name= :name) and (:category is null or e.category= :category)")
    List<Exercise> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(/*@Param("name")*/ String name,/* @Param("category")*/ String category);
}
