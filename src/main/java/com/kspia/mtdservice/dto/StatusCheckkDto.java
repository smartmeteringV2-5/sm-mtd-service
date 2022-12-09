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
 * 개요 : 실시간 현황 조회  StatusCheckkDto생성
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12.9 jung : 최초 작성
 * 2022.12.9 jung : 단말기 카운트 작업
 */
@Data
@NoArgsConstructor
public class StatusCheckkDto {
    //번호
    //검침일
    private String check_day;
    //고객번호
    private String mng_id;
    //성명
    private String wateruser_name;
    //도로명주소
    private String new_address;
    //수용가 번호
    private String wateruser_id;
    //가구 형태
    private String wateruser_indust;
// meterid 계랑기번호
    //구경
    private Integer wateruser_gauge;
    //지침
    private BigDecimal metering_value;
    //온도
    private BigDecimal metering_temp;
    //계랑기 상태
    private Integer meter_backflow; //역류
    private Integer meter_battery; //배터리
    private Integer meter_overflow; //과부화
    private Integer meter_waterleak; //누수
    //단말기 상태
    private String modem_rssi;
    private BigDecimal modem_connect; //결선불량
    private Integer time_sync;
    private BigDecimal modem_battery;
    //검침 일시
    private Date metering_date;
    //수신 일시
    private Date receiving_date;
    //급수전 구분
    private String wateruser_state;



}
