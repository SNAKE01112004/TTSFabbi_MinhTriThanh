package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Integer usersId;

    @Column(name = "users_code")
    private String usersCode;

    @Column(name = "users_name")
    private String usersName;

    @Column(name = "users_email")
    private String usersEmail;

    @Column(name = "users_password")
    private String usersPassword;

    @Column(name = "users_gender")
    private Integer usersGender;

    @Column(name = "users_phone")
    private String usersPhone;

    @Column(name = "users_avatar")
    private String usersAvatar;

    @Column(name = "users_address")
    private String usersAddress;

    @Column(name = "user_target")
    private String userTarget;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "users_birthday")
    private Date usersBirthday;

    @Column(name = "users_province")
    private String usersProvince;

    @Column(name = "users_district")
    private String usersDistrict;

    @Column(name = "users_country_number")
    private String usersCountryNumber;

    @Column(name = "users_status")
    private Boolean usersStatus;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "staff_cskh")
    private StaffCskh staffCskh;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
