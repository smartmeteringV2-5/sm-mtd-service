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

    @Column
    private String adress;

    @Column
    private Date alert_date;

    @Column
    private String caliber;

    @Column
    private String consumer_name;

    @Column
    private String consumer_sid;

    @Column
    private String end_date;

    @Column
    private Boolean is_continous;

    @Column
    private Boolean is_over;

    @Column(precision = 19, scale = 2)
    private BigDecimal leak_predict;

    @Column
    private String start_date;















}
