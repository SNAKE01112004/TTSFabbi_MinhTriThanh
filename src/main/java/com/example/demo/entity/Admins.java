package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "admins")
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admins_id")
    private Integer adminsId;

    @Column(name = "admins_name")
    private String adminsName;

    @Column(name = "admins_name_normalize")
    private String adminsNameNormalize;

    @Column(name = "admins_email")
    private String adminsEmail;

    @Column(name = "admins_avatar")
    private String adminsAvatar;

    @Column(name = "admins_password")
    private String adminsPassword;

    @Column(name = "admins_phone")
    private String adminsPhone;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
