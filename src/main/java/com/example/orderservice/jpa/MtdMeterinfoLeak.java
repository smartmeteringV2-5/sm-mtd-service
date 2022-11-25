package com.example.orderservice.jpa;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "Mtd_Meterinfo_Leak")
public class MtdMeterinfoLeak {

    @EmbeddedId
    private MtdMeterinfoLeakEntity id;

    @Column
    private Integer acube_signal01;

    @Column
    private Integer acube_signal02;

    @Column
    private Date criterion_date;

    @Column
    private BigInteger group_sid;

    @Column
    private String info_tag;

    @Column
    private Integer metering_signal01;

    @Column
    private Integer metering_signal02;

    @Column
    private Integer metering_signal03;

    @Column
    private Integer metering_signal04;

    @Column
    private String metering_state;

    @Column(precision = 10, scale = 3)
    private BigDecimal metering_usage;

    @Column(precision = 10, scale = 3)
    private BigDecimal metering_value;

    @Column
    private Integer  modem_rssi;

    @Column
    private Integer modem_signal01;

    @Column
    private Integer modem_signal02;

    @Column
    private Integer modem_signal03;















}
