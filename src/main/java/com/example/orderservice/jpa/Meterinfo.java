package com.example.orderservice.jpa;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@DynamicInsert
@Data
@Entity
@Table(name = "Meterinfo", indexes = { @Index(name = "index_select_modem_metering_date" , columnList = "metering_date, modem_id"),
        @Index(name = "metering_date" , columnList = "metering_date"),
        @Index(name = "modem_id" , columnList = "modem_id"), @Index(name = "modem_id_re" , columnList = "modem_id")
})
public class Meterinfo {

    @EmbeddedId
    private MeterinfoEntity  meterinfoEntity;

//    @Comment("수신시각")
    @Column(nullable = false)
    private Date receiving_date;

//    @Comment("수신지침")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal metering_value;

//    @Comment("시간당사용")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal metering_usage;

//    @ColumnDefault("-99.000")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal metering_temp;

//    @ColumnDefault("SUCCESS")
//    @Comment("수신상태")
    @Column(nullable = false)
    private String metering_state;

//    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer metering_signal01;

//    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer metering_signal02;

//    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer metering_signal03;

//    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer metering_signal04;

    @Column
    private Integer  modem_rssi;

    @Column
    private Integer modem_signal01;

    @Column
    private Integer modem_signal02;

    @Column
    private Integer modem_signal03;

//    @Comment("생성형태 NORMAL/SMOOTHING")
    @Column
    private String info_tag;

    @Column
    private String info_tag_detail;

//    @ColumnDefault("0")
    @Column
    private Integer acube_signal01;

//    @ColumnDefault("0")
    @Column
    private Integer acube_signal02;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Date insert_date;

    @Column
    private Date update_date;














}
