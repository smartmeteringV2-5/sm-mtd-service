package com.kspia.mtdservice.repository;

import com.kspia.mtdservice.dto.PeriodcheckDto;
import com.kspia.mtdservice.vo.RequestPeriodUsageVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * @since 2022. 12. 21
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 사용량 기간 조회 repository 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022.12. 09 jung : 사용량 기간 조회 작업
 */

@Repository
@Service
public interface PeriodcheckRepository {
    //사용량 기간 조회 검색 리스트
    Page<PeriodcheckDto> periodcheckByList(RequestPeriodUsageVO us, Pageable pageable);
}





