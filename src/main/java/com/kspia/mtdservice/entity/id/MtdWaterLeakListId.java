package com.kspia.mtdservice.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class MtdWaterLeakListId implements Serializable {

    @Column(nullable = false, name = "mng_id")
    private String mong_id;

    @Column(nullable = false,name = "wateruser_type")
    private String wateruser_type;






}
