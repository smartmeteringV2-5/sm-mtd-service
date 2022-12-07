package com.kspia.mtdservice.entity;

import com.kspia.mtdservice.entity.id.MtdWaterLeakListId;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "Mtd_Water_Leak_List")
public class MtdWaterLeakList {

    @EmbeddedId
    private MtdWaterLeakListId id;

    private String adress;

    private Date alert_date;

    private String caliber;

    private String consumer_name;

    private String consumer_sid;

    private String end_date;

    private Boolean is_continous;

    private Boolean is_over;

    @Column(precision = 19, scale = 2)
    private BigDecimal leak_predict;

    private String start_date;















}
