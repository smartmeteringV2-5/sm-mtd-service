package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.service.WatertermService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * 2022. 5. 25 tjdgm : 최초 작성
 * 2022.12. 08 jung : 단말기 카운트 작업
 */
@RestController
@RequestMapping("sm-mtd-service")
public class MtdWaterTermController {

    WatertermService watertermService;

    public MtdWaterTermController(WatertermService watertermService) {
        this.watertermService = watertermService;
    }

    @GetMapping("waterterm")
    public Long TermCont() {
        Long number = watertermService.getTotalCount();
        return number;
    }

}
