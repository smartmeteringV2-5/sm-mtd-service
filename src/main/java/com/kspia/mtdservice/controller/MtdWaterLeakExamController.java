package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.jpa.MtdWaterLeakExamGroupEntity;
import com.kspia.mtdservice.service.GroupServiceImpl;
import com.kspia.mtdservice.service.WateruserServiceImpl;
import com.kspia.mtdservice.vo.RequestGroup;
import com.kspia.mtdservice.vo.RequestWateruser;
import com.querydsl.core.Tuple;
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
    public List<Tuple> getResultList(@RequestBody RequestWateruser wateruser) {
        List<Tuple> wateruserEntityList = wateruserService.getResultList(wateruser);
        return wateruserEntityList;
    }
//    @RequestMapping(value = "/wateruser/test", method = RequestMethod.GET)
//    public List<ConsumerModemInfoEntity> getGetTest (@RequestBody RequestWateruser wateruser) {
//        List<ConsumerModemInfoEntity> wateruserEntityList = wateruserService.getResultList(wateruser);
//        return wateruserEntityList;
//    }




}
