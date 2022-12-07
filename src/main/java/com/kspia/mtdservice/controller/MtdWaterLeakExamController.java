package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.entity.MtdWaterLeakExamGroup;
import com.kspia.mtdservice.service.GroupService;
import com.kspia.mtdservice.service.WateruserService;
import com.kspia.mtdservice.vo.RequestGroup;
import com.kspia.mtdservice.vo.RequestWateruser;
import com.querydsl.core.Tuple;
import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sm-mtd-service")
public class MtdWaterLeakExamController {

    Environment env;
    GroupService groupService;
    WateruserService wateruserService;

    public MtdWaterLeakExamController(Environment env, GroupService groupService, WateruserService wateruserService) {
        this.env = env;
        this.groupService = groupService;
        this.wateruserService = wateruserService;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Mtd Service on PORT %s",
            env.getProperty("local.server.port"));
    }

    @RequestMapping(value = "/group/list", method = RequestMethod.POST)
    public List<MtdWaterLeakExamGroup> getPostList(@RequestBody RequestGroup group) {
        List<MtdWaterLeakExamGroup> groupEntityList = groupService.getPostList(group);
        return groupEntityList;
    }

    @RequestMapping(value = "/wateruser/list", method = RequestMethod.POST)
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
