package com.kspia.mtdservice.vo;

import java.time.LocalDate;
import java.util.Date;

import com.kspia.mtdservice.dto.MeterdailyDto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-14
 * @author MINHYE
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 서버로부터 실시간 사용량 일별 데이터(1주단위)를 담기 위한 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-14 MINHYE : 최초 작성
 */
@Data
@NoArgsConstructor
public class ResponseWeeklyUsage {
    private LocalDate dailyDate;
    private Double dailyUsage;
}
