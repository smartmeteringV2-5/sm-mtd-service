package com.kspia.mtdservice.entity;

import com.kspia.mtdservice.entity.id.MtdMeterinfoLeakId;
import lombok.Data;

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
    private MtdMeterinfoLeakId id;

    private Integer acube_signal01;

    private Integer acube_signal02;

    private Date criterion_date;

    private BigInteger group_sid;

    private String info_tag;

    private Integer metering_signal01;

    private Integer metering_signal02;

    private Integer metering_signal03;

    private Integer metering_signal04;

    private String metering_state;

    @Column(precision = 10, scale = 3)
    private BigDecimal metering_usage;

    @Column(precision = 10, scale = 3)
    private BigDecimal metering_value;

    private Integer  modem_rssi;

    private Integer modem_signal01;

    private Integer modem_signal02;

    private Integer modem_signal03;















}
