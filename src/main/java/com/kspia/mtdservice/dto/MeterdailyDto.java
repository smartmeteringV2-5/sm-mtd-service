package com.kspia.mtdservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @since 2022-12-08
 * @author kkny3
 *
 * @Discript
 * ---------------------------------------------------
 * 개요 : MeterdailyDto 등 관련 Dto 클래스
 * ---------------------------------------------------
 * @EditHIstory
 * 개정이력
 * 2022-12-08 kkny3 : 최초 작성
 * 2022-12-08 kkny3 : MeterdailyDto, MeterdailyDto.ModemCount 작업
 */
@Data
@NoArgsConstructor
public class MeterdailyDto {
    private String modem_id;
    private Date daily_date;
    private BigDecimal past_value;
    private Date metering_date;
    private BigDecimal new_value;
    private BigDecimal daily_usage;
    private Integer meter_backflow;
    private Integer meter_battery;
    private Integer meter_overflow;
    private Integer meter_waterleak;
    private String  modem_rssi;
    private BigDecimal modem_connect;
    private Integer time_sync;
    private String daily_tag;
    private Date insert_date;
    private Date update_date;
    private BigDecimal modem_battery;

    @Data
    @NoArgsConstructor
    public static class ModemCount {
        private int modemLowBatteryCnt;
        private int timeSyncCnt;
        private int disconnectCnt;
    }
    
    @Data
    @NoArgsConstructor
    public static class MeterCount {
        private int meterLowBatteryCnt;
        private int overflowCnt;
        private int waterLeakCnt;
    }
}
