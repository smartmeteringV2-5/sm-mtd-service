package com.kspia.mtdservice.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Embeddable
public class MeterdailyId implements Serializable {
    @Column(nullable = false)
    private String modem_id;

    @Column(nullable = false)
    private LocalDate daily_date;









}
