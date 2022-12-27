package com.kspia.mtdservice.service;

import com.kspia.mtdservice.dto.PeriodcheckDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.vo.RequestPeriodUsageVO;
import com.kspia.mtdservice.vo.RequestUsageHistoryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @since 2022. 12. 21
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 사용량 기간 조회 서비스 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 21 jung : 사용량 기간 조회 작업
 */
public interface PeriodcheckService {
   Page<PeriodcheckDto> getList(RequestPeriodUsageVO us, Pageable pageable);
}
