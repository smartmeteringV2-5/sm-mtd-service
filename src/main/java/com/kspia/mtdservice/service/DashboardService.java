package com.kspia.mtdservice.service;

import com.kspia.mtdservice.vo.RequestEquipState;
import com.kspia.mtdservice.vo.ResponseModemCount;
import com.kspia.mtdservice.vo.ResponseReceivingStateCount;
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
 * 2022-12-09 kkny3 : getEquipStateMap 작업
 * 2022-12-13 kkny3 : getReceivingStateCount 작업
 */
public interface DashboardService {
    ResponseModemCount getModemCount();

    Map<String, Object> getEquipStateMap(RequestEquipState search);

    ResponseReceivingStateCount getReceivingStateCount();
}
