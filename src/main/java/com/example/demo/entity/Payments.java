package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table (name = "payments")
public class Payments extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Dùng AUTO để xử lý UUID
    @Column(name = "transaction_id", columnDefinition = "uniqueidentifier")  // Chỉ định cột là uniqueidentifier
    private UUID transactionId;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users usersId;

    @Column(name = "price_discount")
    private Integer priceDiscount;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_amount")
    private Integer paymentAmount;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @Column(name = "payment_methods")
    private Integer paymentMethods;

    @Column(name = "course_status")
    private Integer courseStatus;

    @ManyToOne
    @JoinColumn(name = "vat_id")
    private Vat vatId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts cartId;
}
