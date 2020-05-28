package com.example.miniprogram.mapper;

import com.example.miniprogram.entity.AppointmentPlus;
import com.example.miniprogram.entity.Dynamic;
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
     DynamicPlus selectDynamicById(long id);
     List<DynamicPlus> selectDynamicsByTags(@Param("region") String region,@Param("identity") String identity,@Param("gender") String gender,@Param("style") String style);
     List<DynamicPlus> selectDynamicByNum();
}
