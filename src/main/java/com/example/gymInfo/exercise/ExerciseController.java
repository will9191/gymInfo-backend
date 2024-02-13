package com.example.gymInfo.exercise;

import com.example.gymInfo.domain.CustomResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    ExerciseRepository repository;

    @PostMapping
    public ResponseEntity postExercise(@RequestBody @Valid ExerciseRequest body) {
        Exercise newExercise = new Exercise(body);
        this.repository.save(newExercise);
        CustomResponse response = new CustomResponse();
        response.setStatusCode("201");
        response.setStatusMsg("Exercício criado com sucesso!");
        response.setBody(newExercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity getAllExercises() {
        List<ExerciseResponseDTO> exerciseList = this.repository.findAll().stream().map(ExerciseResponseDTO::new).toList();
        return ResponseEntity.ok(exerciseList);
    }

    @GetMapping
    public ResponseEntity getExerciseByName(String name, String category) {
        List<ExerciseResponseDTO> exerciseList = this.repository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category).stream().map(ExerciseResponseDTO::new).toList();
        return ResponseEntity.ok(exerciseList);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateExercise(@RequestBody @Valid ExerciseRequest data) {
        Optional<Exercise> optionalExercise = this.repository.findById(data.id());
        if (optionalExercise.isPresent()) {
            Exercise exercise = optionalExercise.get();
            exercise.setName(data.name());
            exercise.setDescription(data.description());
            exercise.setCategory(data.category());
            exercise.setPicture(data.picture());
            CustomResponse response = new CustomResponse();
            response.setStatusCode("201");
            response.setStatusMsg("Exercício criado com sucesso!");
            response.setBody(exercise);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExercise(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
