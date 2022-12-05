package com.example.orderservice.service;

import com.example.orderservice.jpa.MtdWaterLeakExamWateruserEntity;
import com.example.orderservice.vo.RequestWateruser;

import java.util.List;

public interface WateruserService {

    List<MtdWaterLeakExamWateruserEntity> getResultList(RequestWateruser wateruser);
}
