package com.example.miniprogram.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.miniprogram.entity.*;
import com.example.miniprogram.entity.Appointment;
import com.example.miniprogram.mapper.AppointmentMapper;
import com.example.miniprogram.mapper.ComplexMapper;
import com.example.miniprogram.mapper.DynamicMapper;
import com.example.miniprogram.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private ComplexMapper complexMapper;
    @Override
    public List<Appointment> selectAptById1(long id1){
        AppointmentExample example=new AppointmentExample();
        AppointmentExample.Criteria criteria=example.createCriteria();
        criteria.andAppointmentUserid1EqualTo(id1);
        example.setOrderByClause("dynamic_time DESC");
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        System.out.println(appointments);
        return appointments;
    }
    @Override
    public List<Appointment> selectAptById2(long id2){
        AppointmentExample example=new AppointmentExample();
        AppointmentExample.Criteria criteria=example.createCriteria();
        criteria.andAppointmentUserid2EqualTo(id2);
        example.setOrderByClause("dynamic_time DESC");
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        System.out.println(appointments);
        return appointments;
    }
    @Override
    public List<AppointmentPlus> selectReciveApt(long id){
        List<AppointmentPlus> appointmentPlusList = new ArrayList<>();
        appointmentPlusList = complexMapper.selectReceiveApt(id);
        return appointmentPlusList;
    }
    @Override
    public List<AppointmentPlus> selectSendApt(long id){
        List<AppointmentPlus> appointmentPlusList = new ArrayList<>();
        appointmentPlusList = complexMapper.selectSendApt(id);
        return appointmentPlusList;
    }
    @Override
    public int insertAppointment(JSONObject object,String id1,String id2,String dynamicId){
        Appointment appointment=new Appointment();
        appointment.setAppointmentReason(object.getString("reason"));
        appointment.setAppointmentUserid1(Long.parseLong(id1));
        appointment.setAppointmentUserid2(Long.parseLong(id2));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        appointment.setAppointmentTime( df.format(new Date()));
        appointment.setAppointmentFromid(Long.parseLong(dynamicId));
        return appointmentMapper.insertSelective(appointment);
    }
    @Override
    public int updateAgree(long appointment_id,int state){
        Appointment appointment=appointmentMapper.selectByPrimaryKey(appointment_id);
        appointment.setAppointmentAgree(state);
        return appointmentMapper.updateByPrimaryKey(appointment);
    }
    @Override
    public Appointment selectAptById(long id){
        return appointmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int isEqualLogin(long id, long dynamicId) {
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria=appointmentExample.createCriteria();
        criteria.andAppointmentUserid1EqualTo(id).andAppointmentFromidEqualTo(dynamicId);

        return (int)appointmentMapper.countByExample(appointmentExample);
    }

}
