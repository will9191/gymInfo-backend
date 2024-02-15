package com.example.gymInfo.exercise;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository repository;

    public void save(ExerciseRequest request) {
        var exercise = Exercise.builder()
                .id(request.getId())
                .name(request.getName())
                .category(request.getCategory())
                .description(request.getDescription())
                .picture(request.getPicture())
                .build();
        repository.save(exercise);
    }

    public void update(ExerciseRequest request) {

        Optional<Exercise> optionalExercise = repository.findById(request.getId());
        if (optionalExercise.isPresent()) {
                 Exercise exercise = optionalExercise.get();
                 exercise.setName(request.getName());
                 exercise.setDescription(request.getDescription());
                 exercise.setCategory(request.getCategory());
                 exercise.setPicture(request.getPicture());
        } else {
            throw new EntityNotFoundException();
        }

    }

    public List<Exercise> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Exercise> findBySearch(String name, String category) {
        return repository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
    }
}

