package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "user_vouchers")
public class UserVouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_vouchers_id")
    private Integer userVouchersId;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users usersId;

    @ManyToOne
    @JoinColumn(name = "campaign_voucher_id")
    private CampaignVouchers campaignVoucherId;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses coursesId;

    @Column(name = "is_use")
    private Integer is_use;
}
