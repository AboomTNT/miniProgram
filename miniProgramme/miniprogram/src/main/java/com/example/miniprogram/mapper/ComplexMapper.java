package com.example.miniprogram.mapper;

import com.example.miniprogram.entity.AppointmentPlus;
import com.example.miniprogram.entity.DynamicPlus;
import com.example.miniprogram.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplexMapper {
     List<DynamicPlus> selectAllDynamics();
     String selectWx(String id);
     String selectPhone(String id);
     List<AppointmentPlus> selectReceiveApt(long id);
     List<AppointmentPlus> selectSendApt(long id);
}
