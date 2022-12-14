package com.kspia.mtdservice.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Embeddable
public class MeterdataId implements Serializable {
//    @Comment("모뎀번호")
    @Column(nullable = false, name = "modem_id")
    private String modem_id;

//    @Comment("미터링시각")
    @Column(nullable = false,name = "metering_date")
    private Date metering_date;






}
