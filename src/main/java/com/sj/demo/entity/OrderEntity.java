package com.sj.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    private Integer uid;

    private Integer pid;

    private String productName;

    private BigDecimal price;

    @Column(insertable = false, updatable = false)
    private Date createdTime;

    @Column(insertable = false, updatable = false)
    private Date updatedTime;
}
