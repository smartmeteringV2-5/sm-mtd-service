package com.kspia.mtdservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @since 2022. 12. 21
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 기간조회 PeriodcheckDto 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12.21 jung : 최초 작성
 * 2022.12.21 jung : 사용량 기간조회 작업
 */
@Data
@NoArgsConstructor
public class PeriodcheckDto {
    //수용가번호
    private String mngId;
    //성명
    private String consumerName;
    //행정동
    private String dongName;
    //분구
    private String bunguName;
    //시작일
    private LocalDate startDate;
    //종료일
    private LocalDate endDate;
    //시작값
    private BigDecimal startValue;
    //종료값
    private BigDecimal endValue;
    //사용량
    private BigDecimal meteringUsage;



}
