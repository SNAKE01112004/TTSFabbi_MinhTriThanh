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
@Table(name = "exercises")
public class Exercises extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Integer exercisesId;

    @Column(name = "exercise_title")
    private String exerciseTitle;

    @Column(name = "time_complete")
    private Integer timeComplete;

    @ManyToOne
    @JoinColumn(name = "teacher_id ")
    private Teacher teacher;

    @Column(name = "time_review")
    private Integer timeReview;

    @ManyToOne
    @JoinColumn(name = "exercises_data_id")
    private ExercisesData exercisesData;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapters chapter;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lessons lesson;
}
