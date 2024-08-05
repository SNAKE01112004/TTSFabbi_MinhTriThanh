package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chapters")
public class Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Integer chapterId;

    @Column(name = "chapter_name")
    private String chapterName;

    @Column(name = "chapter_order")
    private Integer chapterOrder;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    @Column(name = "total_lecture")
    private Integer totalLecture;

    @Column(name = "total_exercise")
    private Integer totalExercise;

    @Column(name = "total_study_time")
    private Time totalStudyTime;
}
