package com.kspia.mtdservice.service.report;

import com.kspia.mtdservice.dto.report.ReportDto;
import com.kspia.mtdservice.vo.report.RequestReportVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @since 2023. 01. 04
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 검침값 확인 서비스 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2023.01.04 jung: 최초 작성
 * 2023.01.04 jung : 검침값 확인
 */
public interface ReportService {
    Page<ReportDto> getList(RequestReportVo re, Pageable pageable);
}
