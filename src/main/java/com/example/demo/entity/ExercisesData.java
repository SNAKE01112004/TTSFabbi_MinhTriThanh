package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercisesData")
public class ExercisesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercises_data_id")
    private Integer exercisesDataId;

    @Column(name = "question_type")
    private Integer questionType;

    @Column(name = "multiple_choice_type")
    private Integer multipleChoiceType;

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinColumn(name = "answer_id ")
    private Answer answer;
}
