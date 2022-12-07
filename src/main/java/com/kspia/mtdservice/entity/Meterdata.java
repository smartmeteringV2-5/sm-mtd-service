package com.kspia.mtdservice.entity;

import com.kspia.mtdservice.entity.id.MeterdataId;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@DynamicInsert
@Data
@Entity
@Table(name = "Meterdata", indexes = { @Index(name = "meterdata_modem_id_IDX" , columnList = "modem_id"),
        @Index(name = "metering_date_index" , columnList = "metering_date"),
        @Index(name = "receiving_date" , columnList = "receiving_date")
})
public class Meterdata {

    @EmbeddedId
    private MeterdataId meterdataId;

//    @Comment("수신시각")
    @Column(nullable = false)
    private Date receiving_date;

//    @Comment("수신지침")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal metering_value;

//    @ColumnDefault("SUCCESS")
//    @Comment("SUCCESS일 경우 정상, 나머지는 비정상")
    @Column(nullable = false)
    private String metering_state;

//    @ColumnDefault("0")
//    @Comment("과부하검출여부 TRUE:1, FALSE:0")
    @Column(nullable = false)
    private Integer metering_signal01;

//    @ColumnDefault("0")
//    @Comment("옥내누수여부 TRUE:1, FALSE:0")
    @Column(nullable = false)
    private Integer metering_signal02;

//    @ColumnDefault("0")
//    @Comment("역류여부 TRUE:1, FALSE:0")
    @Column(nullable = false)
    private Integer metering_signal03;
//
//    @ColumnDefault("0")
//    @Comment("배터리상태 4:정상, 3:75%, 2:50%, 1:저전압, 0:방전")
    @Column(nullable = false)
    private Integer metering_signal04;

//    @Comment("metering_rssi")
//    @ColumnDefault("0")
    private Integer  modem_rssi;

//    @Comment("모뎀 배터리 상태 (0: 정상, 1: 저전압)")
    private  Integer modem_signal01;

//    @Comment("계량기 통신상태 (0: 정상, 1:통신불가)")
    private  Integer modem_signal02;

//    @Comment("시간상태 동기화(1: 정상, 0: 동기화 불가)")
    private  Integer modem_signal03;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Date insert_date;

    private Date update_date;

//    @ColumnDefault("0.000")
    @Column(precision = 10, scale = 3 )
    private BigDecimal metering_temp;













}
