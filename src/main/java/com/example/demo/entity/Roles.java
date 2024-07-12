package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private Integer roles_id;

    @Column(name = "roles_name")
    private String rolesName;

    @Column(name = "roles_description")
    private String rolesDescription;

    @Column(name = "roles_status")
    private Boolean rolesStatus;
}
