package com.example.miniprogram.entity;

import lombok.Data;

@Data
public class AppointmentPlus {
    private Long appointmentId;
    private Long appointmentUserid1;
    private Long appointmentUserid2;
    private String appointmentTime;
    private Integer appointmentAgree;
    private String appointmentReason;
    private Long appointmentFromid;
    private String userAvater;
    private String userIdentity;
    private String userName;
    private String userAddress;
    private String userGender;

}
