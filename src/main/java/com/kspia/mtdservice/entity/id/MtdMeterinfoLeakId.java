package com.kspia.mtdservice.entity.id;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class MtdMeterinfoLeakId implements Serializable {
    @Column(nullable = false, name = "exam_wateruser_idx")
    private Long exam_wateruser_idx;

    @Column(nullable = false,name = "metering_date")
    private Date metering_date;

    @Column(nullable = false, name = "modem_id")
    private String modem_id;

    @Column(nullable = false,name = "receiving_date")
    private Date receiving_date;






}
