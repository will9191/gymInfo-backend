package com.example.gymInfo.exercise;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Exercise {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String category;
    private String[] primaryMuscle;
    private String[] secondaryMuscles;
    private String description;
    private String equipment;
    private String picture;
}
