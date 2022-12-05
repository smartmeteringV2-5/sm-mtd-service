package com.kspia.mtdservice.service;

import com.kspia.mtdservice.jpa.MtdWaterLeakExamWateruserEntity;
import com.kspia.mtdservice.vo.RequestWateruser;

import java.util.List;

public interface WateruserService {

    List<MtdWaterLeakExamWateruserEntity> getResultList(RequestWateruser wateruser);
}
