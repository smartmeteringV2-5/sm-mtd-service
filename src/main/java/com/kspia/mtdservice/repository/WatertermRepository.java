package com.kspia.mtdservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @since 2022. 12. 8
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 단말기 카운트 작업 repository 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 08 jung : 단말기 카운트 작업
 */

@Repository
@Service
public interface WatertermRepository {
    Long countByTerm();
}
