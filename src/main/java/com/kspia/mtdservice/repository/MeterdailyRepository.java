package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.dto.MeterdailyDto;
import com.kspia.mtdservice.dto.MeterdailyDto.MeterCount;
import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.dto.MeterdailyDto.UsageWeekly;

import com.kspia.mtdservice.vo.RequestEquipState;
import com.kspia.mtdservice.vo.ResponseDashboardMap;
import com.kspia.mtdservice.vo.ResponseModemCount;
import com.kspia.mtdservice.vo.ResponseReceivingStateCount;
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
 * 2022-12-09 kkny3 : findMapListByEquipState 작업
 * 2022-12-13 kkny3 : countByReceivingState 작업
 */
@Repository
public interface MeterdailyRepository {
    MeterCount countByMeterStatus();
    List<UsageWeekly> findByDailyDateAndDailyUsage();
    ResponseModemCount countByModemStatus();

    List<ResponseDashboardMap> findMapListByEquipState(RequestEquipState search);

    ResponseReceivingStateCount countByReceivingState();
}


