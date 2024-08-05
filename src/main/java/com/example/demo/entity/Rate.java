package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table (name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id")
    private Integer rateId;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses coursesIsd;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users usersId;

    @Column(name = "rate_status")
    private Integer rateStatus;

    @Column(name = "is_show")
    private Integer isShow;

    @Column(name = "rate_comment")
    private String rateComment;
}
