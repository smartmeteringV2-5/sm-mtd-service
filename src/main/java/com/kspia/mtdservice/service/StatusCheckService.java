package com.kspia.mtdservice.service;

import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.vo.RequestUsageHistoryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @since 2022. 12. 9
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 서비스 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 09 jung : 실시간 현황 조회 작업
 */
public interface StatusCheckService {
   Page<StatusCheckDto> getSearch(RequestUsageHistoryVO search, Pageable pageable);
}
