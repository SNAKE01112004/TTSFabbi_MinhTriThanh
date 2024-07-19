package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Courses extends BaseEntity {
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

    @Column(name = "efective_duration_money")
    private BigDecimal efectiveDurationMoney;

    @Column(name = "courses_route")
    private Boolean coursesRoute;

    @Column(name = "courses_active")
    private Integer coursesActive;

    @Column(name = "courses_video")
    private String coursesVideo;

    @Column(name = "courses_image")
    private String coursesImage;

    @ManyToOne
    @JoinColumn(name = "courses_classify_id")
    private CoursesClassify coursesClassifyId;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categoriesId;
}
