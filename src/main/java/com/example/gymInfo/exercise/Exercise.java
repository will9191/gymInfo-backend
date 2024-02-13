package com.example.gymInfo.exercise;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "exercise")
@Table(name= "exercise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String category;
    private String description;
    private String picture;

    public Exercise(ExerciseRequest data){
        this.name = data.name();
        this.category = data.category();
        this.description = data.description();
        this.picture = data.picture();
    }
}
