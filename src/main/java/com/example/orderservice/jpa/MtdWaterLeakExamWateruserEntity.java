package com.example.orderservice.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "Mtd_Water_Leak_Exam_Wateruser", indexes = { @Index(name = "FKhe5m1okl6whjid4rxb4qy0r9v" , columnList = "exam_group_idx")})
public class MtdWaterLeakExamWateruserEntity implements Serializable {
    @OneToMany
    @JoinColumn(name = "exam_wateruser_idx")
    private Set<MtdMeterinfoLeak> mtdMeterinfoLeaks;

    @Id
    private Long exam_wateruser_idx;

    @Column
    private String area_id;

    @Column
    private String dividarea;

    @Column
    private String dongno;

    @Column
    private String exam_result;

    @Column
    private Long group_sid;

    @Column(precision = 10, scale = 3)
    private BigDecimal leak_min_usage;

    @Column
    private Long consumer_sid;

    @Column
    private Long exam_group_idx;

    @Column
    private String city;


}
