package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.service.WatertermService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/dashboard/TermCount", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Long> TermCount() {
        List<Long> number = watertermService.getTotalCount();
        return number;
    }

}
