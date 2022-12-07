package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.repository.WateruserRepository;
import com.kspia.mtdservice.service.WateruserService;
import com.kspia.mtdservice.vo.RequestWateruser;
import com.querydsl.core.Tuple;
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
    public List<Tuple> getResultList(RequestWateruser wateruser) {
        return wateruserRepository.findByExamGroupIdx(wateruser.getExam_group_idx());
    }
}
