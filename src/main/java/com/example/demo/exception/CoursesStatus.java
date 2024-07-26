package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum CoursesStatus {
    STATUS_NHAP(1,"Nháp"),
    STATUS_DAXUATBAN(2,"Đã Xuất Bản"),
    STATUS_VOHIEUHOA(0,"Vô hiệu hoá")
    ;
    private int code;
    private String statusMessage;

    CoursesStatus(int code, String statusMessage) {
        this.code = code;
        this.statusMessage = statusMessage;
    }

    public static CoursesStatus fromCode(int code) {
        for (CoursesStatus status : CoursesStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}
