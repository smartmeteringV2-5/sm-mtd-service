package com.kspia.mtdservice.controller;

import com.kspia.mtdservice.dto.SearchListDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.service.StatusCheckService;
import com.kspia.mtdservice.vo.UsagehistoryVO;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RestController
@RequestMapping("/sm-mtd-service")
public class MtdMeteringStatusCheckController {
    private final StatusCheckService statusCheckService;

    @PostMapping(value = "/usageHistory/smartmeter/list/page", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<StatusCheckDto> getSearch(@RequestBody UsagehistoryVO search) throws Exception{
        List<StatusCheckDto> statusCheckList = statusCheckService.getSearch(search);
        return statusCheckList;
    }
}
