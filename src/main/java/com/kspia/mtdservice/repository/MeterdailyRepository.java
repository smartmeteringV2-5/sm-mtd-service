package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.dto.MeterdailyDto;
import com.kspia.mtdservice.dto.MeterdailyDto.MeterCount;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @since 2022-12-08
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : MeterdailyRepository 인터페이스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-08 kkny3 : 최초 작성
 * 2022-12-08 kkny3 : countByModemStatus 작업
 */
@Repository
public interface MeterdailyRepository {
    ModemCount countByModemStatus();
    MeterCount countByMeterStatus();
    List<MeterdailyDto> findAllByDailyDateAndDailyUsage();
}


