package com.kspia.mtdservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseGroup {
    private Long exam_group_idx;
    private String exam_nm;
    private Date exam_finished_dt;
    private Date exam_started_dt;
    private String exam_status;
    private Integer target_cnt;
}
