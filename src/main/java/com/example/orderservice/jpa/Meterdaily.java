package com.example.orderservice.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "meterdaily")
public class Meterdaily {

    @EmbeddedId
    private MeterdailyEntity meterdailyEntity;

//    @Comment("데이터가 만들어지는 시점의 마지막 값")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal fast_value;

//    @Comment("검침값들어오는 시간")
    @Column(nullable = false)
    private Date metering_date;

//    @Comment("검침값들어오는 마지막")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal last_value;

//    @Comment("차이값")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal daily_usage;

//    @Comment("역류 TRUE:1, FALSE:0")
    @Column(nullable = false)
    private Integer backflow;

//    @Comment("계량기 배터리 1~4")
    @Column(nullable = false)
    private Integer meter_battery;

//    @Comment("과부하 TRUE:1, FALSE:0")
    @Column(nullable = false)
    private Integer overflow;

//    @Comment("누수 TRUE:1, FALSE:0")
    @Column(nullable = false)
    private Integer waterleak;

//    @Comment("rssi")
//    @ColumnDefault("'0'")
    private String  modem_rssi;

//    @Comment("결선불량")
    @Column(precision = 2, scale = 1)
    private BigDecimal disconnected;

//    @Comment("타임싱크")
    private Integer time_sync;

//    @Comment("검침상태")
    @Column(nullable = false)
    private String daily_tag;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Date insert_date;

    private Date update_date;

    @Column(nullable = false, precision = 2, scale = 1 )
    private BigDecimal modem_battery;













}
