package com.kspia.mtdservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "message_error_log")
public class MessageErrorLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer log_sid;

    private String log_tag;
    @Column(length = 1000)
    private String log_content;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Date insert_dt;

}
