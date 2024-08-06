package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "carts")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "temp_user_id")
    private String tempUserId;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses coursesId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "cart_status")
    private Integer cartStatus;

    @Column(name = "price")
    private Integer price;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "exprice_time")
    private String expriceTime;
}
