package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.dto.MeterdailyDto;
import com.kspia.mtdservice.dto.MeterdailyDto.MeterCount;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.dto.MeterdailyDto.UsageWeekly;
import com.kspia.mtdservice.service.DashboardService;

import java.util.List;
import com.kspia.mtdservice.service.DashboardService;
import com.kspia.mtdservice.vo.RequestEquipState;
import com.kspia.mtdservice.vo.RequestReceivingState;
import com.kspia.mtdservice.vo.ResponseModemCount;
import com.kspia.mtdservice.vo.ResponseReceivingStateCount;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.kspia.mtdservice.dto.MeterdailyDto.MeterCount;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @since 2022-12-08
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 대시보드 컨트롤러
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-08 kkny3 : 최초 작성
 * 2022-12-08 kkny3 : getModemCount 작업
 * 2022-12-09 kkny3 : getEquipStateMap 작업
 * 2022-12-13 kkny3 : getReceivingStateCount 작업
 * 2022-12-14 kkny3 : getReceivingStateMap 작업
 */
@RestController
@RequestMapping("/sm-mtd-service")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @PostMapping(value = "/dashboard/ModemCount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseModemCount getModemCount() throws Exception {
        return service.getModemCount();
    }
    
    @PostMapping(value = "/dashboard/MeterCount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MeterCount getMeterCount() throws Exception {
        return service.getMeterCount();
    }
    
    @PostMapping(value = "/dashboard/waterUsage/graph/weekly", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UsageWeekly> getDalilyUsageWeekly() throws Exception {
        return service.getDalilyUsageWeekly();
    }
    
    @PostMapping(value = "/dashboard/equipStateMap", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getEquipStateMap(@RequestBody RequestEquipState search) {
        return service.getEquipStateMap(search);
    }

    @PostMapping(value = "/dashboard/ReceivingStateCount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseReceivingStateCount getReceivingStateCount() throws Exception {
        return service.getReceivingStateCount();
    }

    @PostMapping(value = "/dashboard/ReceivingStateMap", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getEquipStateMap(@RequestBody RequestReceivingState search) {
        return service.getReceivingStateMap(search);
    }

}
