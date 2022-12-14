package com.kspia.mtdservice.service;

import com.kspia.mtdservice.vo.RequestEquipState;
import com.kspia.mtdservice.vo.RequestReceivingState;
import com.kspia.mtdservice.vo.ResponseMeterCount;
import com.kspia.mtdservice.vo.ResponseModemCount;
import com.kspia.mtdservice.vo.ResponseReceivingStateCount;
import com.kspia.mtdservice.vo.ResponseWeeklyUsage;

import java.util.List;
import java.util.Map;

/**
 * @since 2022-12-08
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 대시보드 서비스 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-08 kkny3 : 최초 작성
 * 2022-12-08 kkny3 : getModemCount 작업
 * 2022-12-08 MINHYE : getMeterCount 작업
 * 2022-12-09 kkny3 : getEquipStateMap 작업
 * 2022-12-13 kkny3 : getReceivingStateCount 작업
 * 2022-12-13 MINHYE : getDalilyUsageWeekly 작업
 * 2022-12-14 kkny3 : getReceivingStateMap 작업
 */
public interface DashboardService {
	ResponseMeterCount getMeterCount();

    Map<String, Object> getDailyUsageWeekly();
    
    ResponseModemCount getModemCount();

    Map<String, Object> getEquipStateMap(RequestEquipState search);

    ResponseReceivingStateCount getReceivingStateCount();

    Map<String, Object> getReceivingStateMap(RequestReceivingState search);
}
