package com.kspia.mtdservice.entity.report;

import com.kspia.mtdservice.entity.report.Id.MeterDataSeoulNbiotId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "meterdataseoulnbiot")
public class MeterDataSeoulNbiot implements Serializable {

    @EmbeddedId
    private MeterDataSeoulNbiotId meterDataSeoulNbiotId;

    @Column(nullable = false)
    private String imsi;

    @Column(name = "receivingDate",nullable = false)
    private LocalDate receiving_date;

    @Column(nullable = false)
    private Integer rssi;

    @Column(nullable = false)
    private Integer ber;

    @Column(nullable = false)
    private Integer cid;

    @Column(nullable = false)
    private Integer rsrp;

    @Column(nullable = false)
    private Integer rsrq;

    @Column(nullable = false)
    private Integer snr;

    @Column(name = "modemSerial",nullable = false)
    private String modem_serial;

    @Column(name = "modemFwversion",nullable = false)
    private String modem_fwversion;

    @Column(name = "modemBattery",nullable = false)
    private Double modem_battery;

    @Column(name = "meterSerial",nullable = false)
    private String meter_serial;

    @Column(name = "meterType",nullable = false)
    private String meter_type;

    @Column(name = "meterSize",nullable = false)
    private String meter_size;

    @Column(name = "meterStatusOverload",nullable = false)
    private Integer meter_status_overload;

    @Column(name = "meterStatusLeaked",nullable = false)
    private Integer meter_status_leaked;

    @Column(name = "meterStatusReversed",nullable = false)
    private Integer meter_status_reversed;

    @Column(name = "meterStatusBattery",nullable = false)
    private Integer meter_status_battery;

    @Column(name = "meteringInterval",nullable = false)
    private Integer metering_interval;

    @Column(name = "reportingInterval",nullable = false)
    private Integer reporting_interval;

    @Column(name = "meteringValue",nullable = false)
    private Double metering_value;

    @Column(name = "modemTemp",nullable = false)
    private Double modem_temp;

    @Column(name = "insertDate",nullable = false)
    private LocalDate insert_date;

    @Column(name = "updateDate",nullable = false)
    private LocalDate update_date;













}
