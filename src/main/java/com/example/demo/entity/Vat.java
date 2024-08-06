package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "vat")
public class Vat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vat_id")
    private Integer vatId;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "vat_email")
    private String vatEmail;

    @Column(name = "vat_user_name")
    private String vatUserName;

    @Column(name = "vat_address")
    private String vatAddress;

    @Column(name = "vat_receiving_address")
    private String vatReceivingAddress;
}
