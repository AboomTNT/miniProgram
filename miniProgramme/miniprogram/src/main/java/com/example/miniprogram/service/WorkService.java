package com.example.miniprogram.service;

import com.example.miniprogram.entity.Works;
import org.hibernate.jdbc.Work;

import java.util.List;

public interface WorkService {
    public int insertWork(Works work);
    public int deleteWork(long work_id);
    public List<Works> selectWorksByUserId(long user_id);
    public Works selectWorkById(long id);
}
