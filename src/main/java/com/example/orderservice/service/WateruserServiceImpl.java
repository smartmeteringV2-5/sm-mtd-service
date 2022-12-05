package com.example.orderservice.service;

import com.example.orderservice.jpa.MtdWaterLeakExamWateruserEntity;
import com.example.orderservice.repository.WateruserRepository;
import com.example.orderservice.vo.RequestGroup;
import com.example.orderservice.vo.RequestWateruser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WateruserServiceImpl implements WateruserService {
    private final WateruserRepository wateruserRepository;

    @Autowired
    public WateruserServiceImpl(WateruserRepository wateruserRepository) {
        this.wateruserRepository = wateruserRepository;
    }

    @Override
    public List<MtdWaterLeakExamWateruserEntity> getResultList(RequestWateruser wateruser) {
        return wateruserRepository.findByExamGroupIdx(wateruser.getExam_group_idx());
    }
}
