package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.service.StatusCheckService;
import com.kspia.mtdservice.vo.RequestUsageHistoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
@RequiredArgsConstructor
@RestController
@RequestMapping("/sm-mtd-service")
public class MtdMeteringStatusCheckController {
    private final StatusCheckService statusCheckService;

    @RequestMapping(value="/usageHistory/smartmeter/list/page", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<StatusCheckDto> getSearch(@RequestBody RequestUsageHistoryVO search, Pageable pageable){
        Page<StatusCheckDto> statusCheckList = statusCheckService.getSearch(search, pageable);
        System.out.println(statusCheckList);
        return statusCheckList;
    }
}
