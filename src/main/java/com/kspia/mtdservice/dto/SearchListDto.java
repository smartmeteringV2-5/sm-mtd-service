package com.kspia.mtdservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @since 2022. 12. 9
 * @author jung
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : 실시간 현황 조회 SearchListDto 생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12.9 jung : 최초 작성
 * 2022.12.9 jung : 실시간 현황 조회 작업
 */
@Data
@NoArgsConstructor
public class SearchListDto {
    //일자
    private Date dailyDate;
    //사업소
    private String areaId;
    //행정동
    private String dongNm;
    //분구
    private String bunguId;
    //고객번호
    private String mngId;
    //성명
    private String consumerName;
    //도로명주소
    private String newAddress;
    // meterid 계랑기번호
    private String meterId;
    //검침일
    private String checkDay;
    //급수전 구분
    private String consumerState;
    //계랑기 상태
    private String backflow; //역류
    private String meterBattery; //배터리
    private String overflow; //과부화
    private String waterleak; //누수
    //단말기 상태
    private String modem_rssi;
    private String disconnected; //결선불량
    private String timeSync;
    private String modemBattery;
    //구경
    private String consumerCaliber;
}
