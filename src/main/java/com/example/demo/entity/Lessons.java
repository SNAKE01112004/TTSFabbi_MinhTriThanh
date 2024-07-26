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
@Table (name = "lessons")
public class Lessons extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "lesson_discription")
    private String lessonDiscription;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapters chapter;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "lesson_path")
    private String lessonPath;

    @Column(name = "lesson_duration")
    private Integer lessonDuration;

    @Column(name = "lesson_order")
    private Integer lessonOrder;

    @Column(name = "lesson_size")
    private String lessonSize;

    @Column(name = "lesson_file_name")
    private String lessonFileName;

    @Column(name = "lesson_type")
    private Integer lessonType;
}
