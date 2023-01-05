package com.kspia.mtdservice.repository.report;

import com.kspia.mtdservice.dto.report.ReportDto;
import com.kspia.mtdservice.vo.report.RequestReportVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @since 2023. 01. 04
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 검침값 확인 레파지토리 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2023.01.04 jung: 최초 작성
 * 2023.01.04 jung : 검침값 확인
 */
@Repository
@Service
public interface ReportRepository {
    Page<ReportDto> reportCheckByList(RequestReportVo re, Pageable pageable);
}
