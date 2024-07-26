package com.example.demo.entity;

import com.example.demo.exception.CoursesStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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
    private Integer coursesType;

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

    @Column(name = "courses_status")
    private int coursesStatus;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categoriesId;

    public String updateCoursesStatusDisplay() {
        return CoursesStatus.fromCode(this.coursesStatus).getStatusMessage();
    }

}
