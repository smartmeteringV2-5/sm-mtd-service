package com.kspia.mtdservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Mtd_Water_Leak_Exam_Group")
public class MtdWaterLeakExamGroup implements Serializable {
    @Id
    private Long exam_group_idx;

    private String area_id;

    private Date created_date;

    private String created_dept;

    private String created_user;

    private Date exam_estimated_date;

    private Date exam_finished_dt;

    private String exam_nm;

    private Date examPlanStartDt;

    private Date examStartedDt;

    private String exam_status;

    private Long group_sid;

    private Date last_modified_date;

    private String last_modified_dept;

    private String last_modified_user;

    private Integer target_cnt;

    private String city;


}
