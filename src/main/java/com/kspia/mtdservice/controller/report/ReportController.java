package com.kspia.mtdservice.controller.report;

import com.kspia.mtdservice.dto.report.ReportDto;
import com.kspia.mtdservice.service.report.ReportService;
import com.kspia.mtdservice.vo.report.RequestReportVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @since 2023. 01. 04
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 검침값 확인 컨트롤러 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2023.01.04 jung: 최초 작성
 * 2023.01.04 jung : 검침값 확인
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sm-mtd-service")
public class ReportController {
    private final ReportService reportService;
    @ResponseBody
    @RequestMapping(value = "/report/list/page",method ={RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<ReportDto> getList(@RequestBody RequestReportVo re, Pageable pageable){
        Page<ReportDto> reportCheckList = reportService.getList(re, pageable);
        for (ReportDto r : reportCheckList) {
            System.out.println(r.getModemBattery());
        }
        return reportCheckList;
    }
}
