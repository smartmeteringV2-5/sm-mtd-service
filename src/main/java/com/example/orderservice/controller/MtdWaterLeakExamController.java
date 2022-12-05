package com.example.orderservice.controller;

import com.example.orderservice.jpa.MtdWaterLeakExamGroupEntity;
import com.example.orderservice.jpa.MtdWaterLeakExamWateruserEntity;
import com.example.orderservice.service.GroupServiceImpl;
import com.example.orderservice.service.WateruserServiceImpl;
import com.example.orderservice.vo.RequestGroup;
import com.example.orderservice.vo.RequestWateruser;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sm-mtd-service")
public class MtdWaterLeakExamController {
    Environment env;
    GroupServiceImpl groupService;

    WateruserServiceImpl wateruserService;

    public MtdWaterLeakExamController(Environment env,GroupServiceImpl groupService, WateruserServiceImpl wateruserService) {

        this.env = env;
        this.groupService = groupService;
        this.wateruserService = wateruserService;
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

    @RequestMapping(value = "/wateruser/list",method = RequestMethod.POST)
    public List<MtdWaterLeakExamWateruserEntity> getResultList(@RequestBody RequestWateruser wateruser) {
        List<MtdWaterLeakExamWateruserEntity> wateruserEntityList = wateruserService.getResultList(wateruser);
        return wateruserEntityList;
    }




}
