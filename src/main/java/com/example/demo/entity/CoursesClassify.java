package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "courses_classify")
public class CoursesClassify  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courses_classify_id")
    private Integer coursesClassifyId;

    @Column(name = "courses_classify_name")
    private String coursesClassifyName;
}
