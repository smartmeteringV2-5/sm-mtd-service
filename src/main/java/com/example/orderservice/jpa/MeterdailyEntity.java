package com.example.orderservice.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class MeterdailyEntity implements Serializable {
    @Column(nullable = false)
    private String modem_id;

    @Column(nullable = false)
    private Date daily_date;









}
