package com.example.miniprogram.service;

import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Appointment;
import com.example.miniprogram.entity.AppointmentPlus;

import java.util.List;

public interface AppointmentService {
    int insertAppointment(JSONObject object, String id1,String id2,String dynamicId);
    List<Appointment> selectAptById1(long id1);
    List<Appointment> selectAptById2(long id2);
    List<AppointmentPlus> selectReciveApt(long id);
    List<AppointmentPlus> selectSendApt(long id);
    int updateAgree(long appointment_id,int state);
    Appointment selectAptById(long id);
    int isEqualLogin(long id,long dynamicId);
}
