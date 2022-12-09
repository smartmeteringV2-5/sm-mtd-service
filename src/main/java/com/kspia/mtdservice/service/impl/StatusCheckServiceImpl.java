package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.dto.SearchListDto;
import com.kspia.mtdservice.dto.StatusCheckDto;
import com.kspia.mtdservice.repository.StatusCheckRepository;
import com.kspia.mtdservice.service.StatusCheckService;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Service
public class StatusCheckServiceImpl implements StatusCheckService {
    private final StatusCheckRepository statusCheckRepository;

    public StatusCheckServiceImpl(StatusCheckRepository statusCheckRepository) {
        this.statusCheckRepository = statusCheckRepository;
    }

    @Override
    public List<StatusCheckDto> getSearch(SearchListDto sl) {
        return null;
    }
}
