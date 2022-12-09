package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.dto.SearchListDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @since 2022. 12. 9
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 repository 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 09 jung : 실시간 현황 조회 작업
 */

@Repository
@Service
public interface StatusCheckRepository {
    List<SearchListDto> statusCheckByMetering = ;

    List<SearchListDto> statusCheckByMetering();

