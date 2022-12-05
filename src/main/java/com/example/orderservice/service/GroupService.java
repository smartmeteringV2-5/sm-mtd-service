package com.example.orderservice.service;

import com.example.orderservice.jpa.MtdWaterLeakExamGroupEntity;
import com.example.orderservice.vo.RequestGroup;

import java.util.List;
public interface GroupService {
    List<MtdWaterLeakExamGroupEntity> getPostList(RequestGroup group);
}
