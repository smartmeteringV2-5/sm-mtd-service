package com.kspia.mtdservice.service;

import com.kspia.mtdservice.entity.MtdWaterLeakExamGroup;
import com.kspia.mtdservice.vo.RequestGroup;

import java.util.List;
public interface GroupService {
    List<MtdWaterLeakExamGroup> getPostList(RequestGroup group);
}
