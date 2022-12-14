package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.vo.RequestEquipState;
import com.kspia.mtdservice.vo.RequestReceivingState;
import com.kspia.mtdservice.vo.ResponseDashboardMap;
import com.kspia.mtdservice.vo.ResponseMeterCount;
import com.kspia.mtdservice.vo.ResponseModemCount;
import com.kspia.mtdservice.vo.ResponseWeeklyUsage;

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
 * 2022-12-08 MINHYE : countByMeterStatus 작업
 * 2022-12-09 kkny3 : findMapListByEquipState 작업
 * 2022-12-13 kkny3 : countByReceivingState 작업
 * 2022-12-13 MINHYE : findByDailyDateAndDailyUsage 작업
 * 2022-12-14 kkny3 : findMapListByReceivingState 작업
 */
@Repository
public interface MeterdailyRepository {
	ResponseMeterCount countByMeterStatus();
    
    List<ResponseWeeklyUsage> findByDailyDateAndDailyUsage();
    
    ResponseModemCount countByModemStatus();

    List<ResponseDashboardMap> findMapListByEquipState(RequestEquipState search);

    int countByReceivingState(String receivingState);

    List<ResponseDashboardMap> findMapListByReceivingState(RequestReceivingState search);
}


