package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter

@Entity
@Table(name = "categories")
public class Categories extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Integer categoriesId;

    @Column(name = "categories_name")
    private String categoriesName;

    @Column(name = "categories_color")
    private String categoriesColor;

    @Column(name = "categories_tag")
    private String categoriesTag;
}
