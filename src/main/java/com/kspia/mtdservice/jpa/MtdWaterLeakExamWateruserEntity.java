package com.kspia.mtdservice.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "Mtd_Water_Leak_Exam_Wateruser", indexes = { @Index(name = "FKhe5m1okl6whjid4rxb4qy0r9v" , columnList = "exam_group_idx")})
public class MtdWaterLeakExamWateruserEntity implements Serializable {
    @OneToMany
    @JoinColumn(name = "exam_wateruser_idx")
    private Set<MtdMeterinfoLeak> mtdMeterinfoLeaks;

//    @OneToMany
//    @JoinColumn(name = "exam_group_idx")
//    private Set<MtdWaterLeakExamGroupEntity> mtdWaterLeakExamGroupEntities;

    @Id
    private Long exam_wateruser_idx;

    @Column(name = "area_id")
    private String areaId;
    @Column(name = "dividarea")
    private String dividarea;
    @Column(name = "dongno")
    private String dongno;
    @Column(name = "exam_result")
    private String examResult;
    @Column(name = "group_sid")
    private Long groupSid;
    @Column(precision = 10, scale = 3)
    private BigDecimal leakMinUsage;
    @Column(name = "consumer_sid")
    private Long consumer_sid;
    @Column(name = "exam_group_idx")
    private Long examGroupIdx;
    @Column(name = "city")
    private String city;


}
