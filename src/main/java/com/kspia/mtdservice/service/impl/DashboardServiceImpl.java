package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.dto.MeterdailyDto.MeterCount;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.repository.MeterdailyRepository;
import com.kspia.mtdservice.service.DashboardService;
import org.springframework.stereotype.Service;

/**
 * @since 2022-12-08
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 대시보드 서비스 Impl
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-08 kkny3 : 최초 작성
 * 2022-12-08 kkny3 : getModemCount 작업
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    private final MeterdailyRepository meterdailyRepository;

    public DashboardServiceImpl(MeterdailyRepository meterdailyRepository) {
        this.meterdailyRepository = meterdailyRepository;
    }

    public ModemCount getModemCount() {
      return meterdailyRepository.countByModemStatus();
    }
    
    public MeterCount getMeterCount() {
        return meterdailyRepository.countByMeterStatus();
      }
}
