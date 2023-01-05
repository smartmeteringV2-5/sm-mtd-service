package com.kspia.mtdservice.entity.report.Id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Embeddable
public class MeterDataSeoulNbiotId implements Serializable {
    @Column(nullable = false)
    private String imei;

    @Column(name = "meteringDate", nullable = false)
    private LocalDate metering_date;









}
