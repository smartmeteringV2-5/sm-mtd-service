package com.example.orderservice.jpa;

import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Embeddable
public class MtdMeterinfoLeakEntity implements Serializable {
    @Column(nullable = false, name = "exam_wateruser_idx")
    private Long exam_wateruser_idx;

    @Column(nullable = false,name = "metering_date")
    private Date metering_date;

    @Column(nullable = false, name = "modem_id")
    private String modem_id;

    @Column(nullable = false,name = "receiving_date")
    private Date receiving_date;






}
