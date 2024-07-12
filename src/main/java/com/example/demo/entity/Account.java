package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "username_account")
    private String usernameAccount;

    @Column(name = "email_account")
    private String emailAccount;

    @Column(name = "password_account")
    private String passwordAccount;

    @Column(name = "lastlogin_account")
    private Date lastloginAccount;
}
