package com.kspia.mtdservice.service;

import com.kspia.mtdservice.jpa.MtdWaterLeakExamGroupEntity;
import com.kspia.mtdservice.vo.RequestGroup;

import java.util.List;
public interface GroupService {
    List<MtdWaterLeakExamGroupEntity> getPostList(RequestGroup group);
}
