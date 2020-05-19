package com.example.miniprogram.service;

import com.example.miniprogram.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    public int insertAppointment(Appointment appointment);
    public List<Appointment> selectAptById1(long id1);
    public List<Appointment> selectAptById2(long id2);
    public int updateAgree(long appointment_id);
    public Appointment selectAptById(long id);
}
