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
@NoArgsConstructor //
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

    @Column(name = "courses_price")
    private BigDecimal coursesPrice;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categoriesId;
}
