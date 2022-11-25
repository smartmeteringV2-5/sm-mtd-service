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
@Table(name = "Mtd_Water_Leak_List")
public class MtdWaterLeakList {

    @EmbeddedId
    private MtdWaterLeakListEntity id;

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
