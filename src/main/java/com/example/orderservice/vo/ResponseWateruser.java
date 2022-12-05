package com.example.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWateruser {
    private Long exam_wateruser_idx;
    private String exam_result;
    private BigDecimal leak_min_usage;
    private String mng_id;
    private String wateruser_type;
    private String wateruser_name;
    private String new_address;
    private String wateruser_indust;
    private String wateruser_state;
    private String area_nm;
}
//mngId wateruserType consumerName newAdress consumerType areaName consumerState
// examResult leakMinUsage 변수명