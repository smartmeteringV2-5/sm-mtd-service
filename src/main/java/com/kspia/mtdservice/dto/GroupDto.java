package com.kspia.mtdservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GroupDto implements Serializable {
    private Date exam_finished_dt;
    private String exam_nm;
    private Date exam_started_dt;
    private String exam_status;
    private Integer target_cnt;


}
