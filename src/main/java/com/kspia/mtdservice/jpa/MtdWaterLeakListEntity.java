package com.kspia.mtdservice.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class MtdWaterLeakListEntity implements Serializable {

    @Column(nullable = false, name = "mng_id")
    private String mong_id;

    @Column(nullable = false,name = "wateruser_type")
    private String wateruser_type;






}
