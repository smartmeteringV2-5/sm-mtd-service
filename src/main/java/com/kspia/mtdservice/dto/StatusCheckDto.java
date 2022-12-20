package com.kspia.mtdservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @since 2022. 12. 9
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회  StatusCheckkDto생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12.9 jung : 최초 작성
 * 2022.12.9 jung : 단말기 카운트 작업
 */
@Data
@NoArgsConstructor
public class StatusCheckDto {
    //번호
    //검침일
    private String checkDay;
    //고객번호
    private String mngId;
    //성명
    private String consumerName;
    //도로명주소
    private String newAddress;
    //수용가 번호
    private String waterUserId;
    //가구 형태
    private String waterUserIndust;
// meterid 계랑기번호
    private String meterId;
    //구경
    private String consumerCaliber;
    //지침
    private BigDecimal meteringValue;
    //온도
    private BigDecimal meteringTemp;
    //계랑기 상태
    private String backflow; //역류
    private String meterBattery; //배터리
    private String overflow; //과부화
    private String waterleak; //누수
    //단말기 상태
    private String disconnected; //결선불량
    private String timeSync;
    private String modemBattery;
    //검침 일시
    private Date meteringDate;
    //수신 일시
    private Date receivingDate;
    //급수전 구분
    private String waterUserState;
}
