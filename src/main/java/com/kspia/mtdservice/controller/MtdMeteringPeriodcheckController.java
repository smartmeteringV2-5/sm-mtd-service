package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.dto.PeriodcheckDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.service.PeriodcheckService;
import com.kspia.mtdservice.vo.RequestPeriodUsageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @since 2022. 12. 21
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 사용량 기간조회 컨트롤러 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12.21 jung: 최초 작성
 * 2022.12.21 jung : 사용량 기간조회
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sm-mtd-service")
public class MtdMeteringPeriodcheckController {
    private final PeriodcheckService periodcheckService;
    @ResponseBody
    @RequestMapping(value = "/periodUsage/list/page", method ={RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<PeriodcheckDto> getList(@RequestBody RequestPeriodUsageVO us, Pageable pageable){
        Page<PeriodcheckDto> periodCheckList = periodcheckService.getList(us, pageable);
        for (PeriodcheckDto p : periodCheckList){
            p.setStartDate(LocalDate.from(us.getFromDate()));
        }
        return periodCheckList;

    }
}
