package com.example.orderservice.service;

import com.example.orderservice.repository.GroupRepository;
import com.example.orderservice.jpa.MtdWaterLeakExamGroupEntity;
import com.example.orderservice.vo.RequestGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<MtdWaterLeakExamGroupEntity> getPostList(RequestGroup group) {
        return groupRepository.findByExamPlanStartDtBetween(group.getFromDate(), group.getToDate());
    }
}
