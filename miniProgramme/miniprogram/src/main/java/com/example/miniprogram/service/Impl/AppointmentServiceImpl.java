package com.example.miniprogram.service.Impl;

import com.example.miniprogram.entity.Appointment;
import com.example.miniprogram.entity.AppointmentExample;
import com.example.miniprogram.entity.Appointment;
import com.example.miniprogram.entity.UserExample;
import com.example.miniprogram.mapper.AppointmentMapper;
import com.example.miniprogram.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Resource
    private AppointmentMapper appointmentMapper;
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
    public int insertAppointment(Appointment appointment){
       return appointmentMapper.insertSelective(appointment);
    }
    @Override
    public int updateAgree(long appointment_id){
        Appointment appointment=appointmentMapper.selectByPrimaryKey(appointment_id);
        appointment.setAppointmentAgree(1);
        return appointmentMapper.updateByPrimaryKey(appointment);
    }
    @Override
    public Appointment selectAptById(long id){
        return appointmentMapper.selectByPrimaryKey(id);
    }

}
