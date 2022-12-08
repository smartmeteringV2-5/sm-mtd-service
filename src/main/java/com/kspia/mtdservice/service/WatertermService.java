package com.kspia.mtdservice.service;

import org.springframework.stereotype.Service;

/**
 * @since 2022. 12. 8
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 단말기 카운트 서비스 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022. 5. 25 tjdgm : 최초 작성
 * 2022.12. 08 jung : 단말기 카운트 작업
 */
public interface WatertermService {
    Long getTotalCount();
}
