package com.kspia.mtdservice.service.report.impl;

import com.kspia.mtdservice.dto.report.ReportDto;
import com.kspia.mtdservice.repository.report.ReportRepository;
import com.kspia.mtdservice.service.report.ReportService;
import com.kspia.mtdservice.vo.report.RequestReportVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @since 2023. 01. 04
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 검침값 확인 서비스임플 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2023.01.04 jung: 최초 작성
 * 2023.01.04 jung : 검침값 확인
 */
@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    @Override
    public Page<ReportDto> getList(RequestReportVo re, Pageable pageable) {
        return reportRepository.reportCheckByList(re,pageable);
    }
}
