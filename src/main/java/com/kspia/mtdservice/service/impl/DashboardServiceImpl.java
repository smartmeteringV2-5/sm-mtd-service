package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.dto.MeterdailyDto.MeterCount;
import com.kspia.mtdservice.dto.MeterdailyDto.UsageWeekly;
import com.kspia.mtdservice.repository.MeterdailyRepository;
import com.kspia.mtdservice.service.DashboardService;
import com.kspia.mtdservice.vo.RequestEquipState;
import com.kspia.mtdservice.vo.RequestReceivingState;
import com.kspia.mtdservice.vo.ResponseModemCount;
import com.kspia.mtdservice.vo.ResponseReceivingStateCount;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * 2022-12-09 kkny3 : getEquipStateMap 작업
 * 2022-12-13 kkny3 : getReceivingStateCount 작업
 * 2022-12-14 kkny3 : getReceivingStateMap 작업
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    private final MeterdailyRepository meterdailyRepository;

    public DashboardServiceImpl(MeterdailyRepository meterdailyRepository) {
        this.meterdailyRepository = meterdailyRepository;
    }

    @Override
    public ResponseModemCount getModemCount() {
      return meterdailyRepository.countByModemStatus();
    }
    
    public MeterCount getMeterCount() {
        return meterdailyRepository.countByMeterStatus();
      }
    
    public List<UsageWeekly> getDalilyUsageWeekly() {
        return meterdailyRepository.findByDailyDateAndDailyUsage();
      }

    @Override
    public Map<String, Object> getEquipStateMap(RequestEquipState search) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalResult", meterdailyRepository.findMapListByEquipState(search));
        return resultMap;
    }

    @Override
    public ResponseReceivingStateCount getReceivingStateCount() {
        List<String> receivingStates = Arrays.asList("normalReception", "noReception", "longTermNoReception");
        Map<String, Integer> map = new HashMap<>();
        for (String receivingState : receivingStates) {
            int count = meterdailyRepository.countByReceivingState(receivingState);
            map.put(receivingState, count);
        }
        return ResponseReceivingStateCount.convertMap(map);
    }

    @Override
    public Map<String, Object> getReceivingStateMap(RequestReceivingState search) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("content", meterdailyRepository.findMapListByReceivingState(search));
        return resultMap;
    }
}
