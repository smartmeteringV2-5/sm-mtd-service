package com.kspia.mtdservice.service.impl;

import com.kspia.mtdservice.repository.WatertermRepository;
import com.kspia.mtdservice.service.WatertermService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class WatertermServiceImpl implements WatertermService {

    private final WatertermRepository watertermRepository;

    public WatertermServiceImpl(WatertermRepository watertermRepository) {
        this.watertermRepository = watertermRepository;
    }

    @Override
    public Long getTotalCount() {
        return watertermRepository.count();
    }
}
