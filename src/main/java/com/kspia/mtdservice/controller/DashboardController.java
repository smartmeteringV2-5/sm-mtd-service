package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.dto.MeterdailyDto.EquipStateMap;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.service.DashboardService;
import com.kspia.mtdservice.vo.RequestSearch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ModemCount getModemCount() throws Exception {
        return service.getModemCount();
    }

    @PostMapping(value = "/dashboard/equipStateMap", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getEquipStateMap(@RequestBody RequestSearch search) {
        return service.getEquipStateMap(search);
    }
}
