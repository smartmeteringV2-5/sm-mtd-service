package com.kspia.mtdservice.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "consumer_modem_info")
@Immutable
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ConsumerModemInfo implements Serializable {
    @Id
    private Long consumer_sid;

    private String mng_id;

    private String wateruser_id;

    private String wateruser_name;

    private String check_day;

    private String wateruser_gauge;

    private String wateruser_indust;

    private String wateruser_state;

    private String wateruser_type;

    @Column(length = 510)
    private String new_address;

    @Column(length = 510)
    private String old_address;

    private Long group_sid;

    private Date install_date;

    private String modem_company;

    private String modem_id;

    private String modem_telecom;

    private String dividarea;

    private String area_id;

    private String area_nm;

    private String dong_cd;

    private String dong_nm;

    private String employer_name;

    private String employer_no;

    private String block_l_cd;

    private String block_m_cd;

    private String block_s_cd;

    @Column(length = 511)
    private String vworld_gps;

    private String geo_x;

    private String geo_y;

    @Column(length = 511)
    private String google_gps;

    private String google_x;

    private String google_y;

    private String daum_x;

    private String daum_y;

    @Column(length = 511)
    private String daum_gps;





}
