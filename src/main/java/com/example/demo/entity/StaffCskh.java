package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "staff_cskh")
public class StaffCskh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_cskh_id")
    private Integer staffCskhId;

    @Column(name = "name_cskh")
    private String nameCskh;
}
