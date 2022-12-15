package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.repository.WatertermRepository;
import com.kspia.mtdservice.service.WatertermService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @since 2022. 12. 8
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 단말기 카운트 서비스 Impl
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 08 jung : 최초작성
 * 2022.12. 08 jung : 단말기 카운트 작업
 */
@Service
public class WatertermServiceImpl implements WatertermService {

    private final WatertermRepository watertermRepository;

    public WatertermServiceImpl(WatertermRepository watertermRepository) {
        this.watertermRepository = watertermRepository;
    }

    @Override
    public Long getTotalCount() {

        return watertermRepository.countByTerm();
    }
}
