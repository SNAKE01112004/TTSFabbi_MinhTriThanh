package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courses_id")
    private Integer coursesId;

    @Column(name = "courses_name")
    private String coursesName;

    @Column(name = "courses_description")
    private String coursesDescription;

    @Column(name = "courses_customer_description")
    private String coursesCustomerDescription;

    @Column(name = "benifit_buy_courses")
    private String benifitBuyCourses;

    @Column(name = "courses_type")
    private Boolean coursesType;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categoriesId;

    @ManyToOne
    @JoinColumn(name = "courses_classify_id")
    private CoursesClassify coursesClassifyId;

    @Column(name = "course_route")
    private Boolean courseRoute;

    @Column(name = "time_active")
    private Integer timeActive;

    @Column(name = "course_video")
    private String courseVideo;

    @Column(name = "course_image")
    private String courseImage;
}
