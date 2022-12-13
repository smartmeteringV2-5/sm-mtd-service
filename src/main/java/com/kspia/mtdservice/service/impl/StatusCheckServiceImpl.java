package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.repository.StatusCheckRepository;
import com.kspia.mtdservice.service.StatusCheckService;
import com.kspia.mtdservice.vo.RequestUsageHistoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @since 2022. 12. 9
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 Impl 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 09 jung : 최초작성
 * 2022.12. 09 jung : 실시간 현황 조회 작업
 */
@RequiredArgsConstructor
@Service
public class StatusCheckServiceImpl implements StatusCheckService {
    private final StatusCheckRepository statusCheckRepository;

    @Override
    public Page<StatusCheckDto> getSearch(RequestUsageHistoryVO search, Pageable pageable) {
        return statusCheckRepository.statusCheckByMetering(search, pageable);
    }
}
