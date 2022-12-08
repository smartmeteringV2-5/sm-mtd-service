package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.service.WatertermService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
