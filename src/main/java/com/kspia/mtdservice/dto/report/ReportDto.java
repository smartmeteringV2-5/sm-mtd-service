package com.kspia.mtdservice.dto.report;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * @since 2023. 01. 04
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 검침값 확인 Dto 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2023.01.04 jung: 최초 작성
 * 2023.01.04 jung : 검침값 확인
 */

@Data
@NoArgsConstructor
public class ReportDto {
    private String imei;

    private LocalDate meteringDate;

    private String modemBattery;

    private String meteringValue;
}
