package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.service.WatertermService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since 2022. 12. 8
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 단말기 카운트 조회 컨트롤러
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 08 jung : 단말기 카운트 작업
 */
@RestController
@RequestMapping("sm-mtd-service")
public class MtdWaterTermController {

    WatertermService watertermService;

    public MtdWaterTermController(WatertermService watertermService) {
        this.watertermService = watertermService;
    }

    @PostMapping(value = "/dashboard/InstallCount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Integer> termCount() throws Exception{

        Map<String, Integer> map = new HashMap<>();
        List<Long> number = watertermService.getTotalCount();
        int cnt = Math.toIntExact(number.get(0));
        map.put("installCnt", cnt);
        return map;
    }

}
