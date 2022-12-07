package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.entity.MtdWaterLeakExamGroup;
import com.kspia.mtdservice.repository.GroupRepository;
import com.kspia.mtdservice.service.GroupService;
import com.kspia.mtdservice.vo.RequestGroup;
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
    public List<MtdWaterLeakExamGroup> getPostList(RequestGroup group) {
        return groupRepository.findByExamPlanStartDtBetween(group.getFromDate(), group.getToDate());
    }
}
