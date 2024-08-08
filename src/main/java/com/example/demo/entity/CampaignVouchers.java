package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "campaign_vouchers")
public class CampaignVouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_vouchers_id")
    private Integer campaignVouchersId;

    @Column(name = "campaign_name")
    private String campaignName;

    @Column(name = "campaign_description")
    private String campaignDescription;

    @Column(name = "campaign_type")
    private Integer campaignType;

    @Column(name = "applicable")
    private Integer applicable;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "condition_birthday")
    private Integer conditionBirthday;

    @Column(name = "condition_spending_from")
    private Integer conditionSpendingFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "condition_account_from")
    private Date conditionAccountFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "condition_account_to")
    private Date conditionAccountTo;

    @Column(name = "condition_gender")
    private Integer conditionGender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "promotion_from")
    private Date promotionFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "promotion_to")
    private Date promotionTo;

    @Column(name = "discount_type")
    private Integer discountType;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "minimum_spending")
    private Integer minimumSpending;

    @Column(name = "number_voucher")
    private Integer numberVoucher;

    @Column(name = "limit_voucher")
    private Integer limitVoucher;

    @Column(name = "main_course_id")
    private Integer mainCourseId;

    @Column(name = "voucher_status")
    private Integer voucherStatus;

    @Column(name = "total_buy")
    private Integer totalBuy;

    @Column(name = "total_used")
    private Integer totalUsed;

    @Column(name = "sold_out_course")
    private Integer soldOutCourse;

    @Column(name = "course_used")
    private Integer courseUsed;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses coursesId;
}
