package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.dto.PeriodcheckDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.repository.PeriodcheckRepository;
import com.kspia.mtdservice.repository.StatusCheckRepository;
import com.kspia.mtdservice.service.PeriodcheckService;
import com.kspia.mtdservice.service.StatusCheckService;
import com.kspia.mtdservice.vo.RequestPeriodUsageVO;
import com.kspia.mtdservice.vo.RequestUsageHistoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @since 2022. 12. 21
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 사용량 기간 조회 서비스임플 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 21 jung : 최초작성
 * 2022.12. 21 jung : 사용량 기간 조회 작업
 */
@RequiredArgsConstructor
@Service
public class PeriodcheckServiceImpl implements PeriodcheckService {
    private final PeriodcheckRepository periodcheckRepository;

    @Override
    public Page<PeriodcheckDto> getList(RequestPeriodUsageVO us, Pageable pageable) {
        return periodcheckRepository.periodcheckByList(us, pageable);
    }
}
