package com.example.miniprogram.controller;

import com.example.miniprogram.entity.Appointment;
import com.example.miniprogram.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/selectAptById1")
    public List<Appointment> selectAptById1(long id1){
        return appointmentService.selectAptById1(id1);

    }
    @GetMapping("/selectAptById2")
    public List<Appointment> selectAptById2(long id2){
        return appointmentService.selectAptById1(id2);
    }
    @GetMapping("/insert")
    public int insertAppointment(@RequestParam("insertAppointment") Appointment appointment){
        return  appointmentService.insertAppointment(appointment);
    }
    @GetMapping("updateAgree")
    public int updateAgree(long appointment_id){
        return appointmentService.updateAgree(appointment_id);
    }
}
