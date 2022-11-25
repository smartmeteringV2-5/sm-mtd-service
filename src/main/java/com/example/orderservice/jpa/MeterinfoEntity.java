package com.example.orderservice.jpa;

import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Embeddable
public class MeterinfoEntity implements Serializable {
//    @Comment("모뎀번호")
    @Column(nullable = false, name = "modem_id")
    private String modem_id;

//    @Comment("미터링시각")
    @Column(nullable = false, name = "metering_date")
    private LocalDateTime metering_date;






}
