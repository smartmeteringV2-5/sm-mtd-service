package com.kspia.mtdservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "Orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Timestamp created_at;

    @Column(nullable = false, unique = true)
    private String order_id;

    @Column(nullable = false, unique = true)
    private String product_id;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Integer total_price;

    @Column(nullable = false)
    private Integer unit_price;

    @Column(nullable = false)
    private String user_id;


}
