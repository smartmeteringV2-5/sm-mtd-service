package com.kspia.mtdservice.service;

import com.kspia.mtdservice.vo.RequestWateruser;
import com.querydsl.core.Tuple;

import java.util.List;

public interface WateruserService {

    List<Tuple> getResultList(RequestWateruser wateruser);
}
