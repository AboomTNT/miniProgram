package com.example.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.Appointment;
import com.example.miniprogram.entity.AppointmentPlus;
import com.example.miniprogram.entity.User;
import com.example.miniprogram.service.AppointmentService;
import com.example.miniprogram.service.DynamicService;
import com.example.miniprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private  DynamicService dynamicService;

    @GetMapping("/selectReciveApt")
    public String selectReciveApt(HttpServletRequest request) {
        String id = request.getSession().getAttribute("id").toString();
        List<AppointmentPlus> appointmentPlusList = appointmentService.selectReciveApt(Long.parseLong(id));
        return JSON.toJSONString(appointmentPlusList);

    }

    @GetMapping("/selectSendApt")
    public String selectSendApt(HttpServletRequest request) {
        String id = request.getSession().getAttribute("id").toString();
        List<AppointmentPlus> appointmentPlusList = appointmentService.selectSendApt(Long.parseLong(id));
        return JSON.toJSONString(appointmentPlusList);

    }

    @GetMapping("/appointmentReply")
    public int appointmentReply(HttpServletRequest request) {
        String appointmentId = request.getParameter("appointmentId");
        int status = Integer.parseInt(request.getParameter("status"));
        return appointmentService.updateAgree(Long.parseLong(appointmentId), status);
    }

    @GetMapping("/selectAptById1")
    public List<Appointment> selectAptById1(long id1) {
        return appointmentService.selectAptById1(id1);

    }

    @GetMapping("/selectAptById2")
    public List<Appointment> selectAptById2(long id2) {
        return appointmentService.selectAptById1(id2);
    }

    @GetMapping("/insertAppointment")
    public int insertAppointment(HttpServletRequest request) {
        JSONObject appointment = JSON.parseObject(request.getParameter("appointment"));
        String id1 = request.getSession().getAttribute("id").toString();
        String id2 = request.getParameter("id");
        String dynamicId = request.getParameter("dynamicId");
        dynamicService.updateDynamicNum(Long.parseLong(dynamicId));
        if (id1.equals(id2))
            return 0;
        return appointmentService.insertAppointment(appointment, id1, id2, dynamicId);
    }
}
