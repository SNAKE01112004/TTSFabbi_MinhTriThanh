package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "roles_account")
public class RoleAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_account_id")
    private Integer rolesAccountId;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
