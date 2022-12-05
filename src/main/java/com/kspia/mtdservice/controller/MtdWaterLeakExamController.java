package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.jpa.MtdWaterLeakExamGroupEntity;
import com.kspia.mtdservice.service.GroupServiceImpl;
import com.kspia.mtdservice.vo.RequestGroup;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sm-mtd-service")
public class MtdWaterLeakExamController {
    Environment env;
    GroupServiceImpl groupService;



    public MtdWaterLeakExamController(Environment env,GroupServiceImpl groupService) {

        this.env = env;
        this.groupService = groupService;
    }

    @GetMapping("/health_check")
    public String status() {
        return  String.format("It's Working in Mtd Service on PORT %s",
                env.getProperty("local.server.port"));
   }

    @RequestMapping(value = "/group/list",method = RequestMethod.POST)
    public List<MtdWaterLeakExamGroupEntity> getPostList(@RequestBody RequestGroup group) {
        List<MtdWaterLeakExamGroupEntity> groupEntityList = groupService.getPostList(group);
        return groupEntityList;
    }





}
