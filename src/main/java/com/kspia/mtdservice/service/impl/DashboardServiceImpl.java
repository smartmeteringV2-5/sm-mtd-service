package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.dto.MeterdailyDto.ModemCount;
import com.kspia.mtdservice.repository.MeterdailyRepository;
import com.kspia.mtdservice.service.DashboardService;
import com.kspia.mtdservice.vo.RequestSearch;
import java.util.HashMap;
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
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    private final MeterdailyRepository meterdailyRepository;

    public DashboardServiceImpl(MeterdailyRepository meterdailyRepository) {
        this.meterdailyRepository = meterdailyRepository;
    }

    @Override
    public ModemCount getModemCount() {
      return meterdailyRepository.countByModemStatus();
    }

    @Override
    public Map<String, Object> getEquipStateMap(RequestSearch search) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalResult", meterdailyRepository.findMapListByEquipState(search));
        return resultMap;
    }
}
