package com.example.orderservice.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "Mtd_Water_Leak_Exam_Group")
public class MtdWaterLeakExamGroupEntity implements Serializable {
    @Id
    private Long exam_group_idx;

    @Column
    private String area_id;

    @Column
    private Date created_date;

    @Column
    private String created_dept;

    @Column
    private String created_user;

    @Column
    private Date exam_estimated_date;

    @Column
    private Date exam_finished_dt;

    @Column
    private String exam_nm;

    @Column
    private Date exam_plan_start_dt;

    @Column
    private Date exam_started_dt;

    @Column
    private String exam_status;

    @Column
    private Long group_sid;

    @Column
    private Date last_modified_date;

    @Column
    private String last_modified_dept;

    @Column
    private String last_modified_user;

    @Column
    private Integer target_cnt;

    @Column
    private String city;


}
