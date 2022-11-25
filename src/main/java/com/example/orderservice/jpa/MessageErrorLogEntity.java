package com.example.orderservice.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Message_Error_Log")
public class MessageErrorLogEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer log_sid;

    private String log_tag;
    @Column(length = 1000)
    private String log_content;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Date insert_dt;

}
