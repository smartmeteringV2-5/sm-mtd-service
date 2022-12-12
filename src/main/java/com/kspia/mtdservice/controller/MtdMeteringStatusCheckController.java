package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.dto.SearchListDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.service.StatusCheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since 2022. 12. 9
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 컨트롤러 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 09 jung : 실시간 현황 조회 작업
 */
@RestController
@RequestMapping("/sm-mtd-service")
public class MtdMeteringStatusCheckController {

    StatusCheckService statusCheckService;

    public MtdMeteringStatusCheckController(StatusCheckService statusCheckService){
        this.statusCheckService = statusCheckService;
    }


    @PostMapping(value = "/smartmeter/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<StatusCheckDto> getSearch(@RequestBody SearchListDto sl) throws Exception{
        List<StatusCheckDto> statusCheckList = statusCheckService.getSearch(sl);
        System.out.println("sl = " + sl);
        return statusCheckList;
    }


}
