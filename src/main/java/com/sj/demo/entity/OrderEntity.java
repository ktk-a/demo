package com.sj.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "order")
public class OrderEntity {

    @Id
    private String oid;

    private String uid;

    private String pid;

    private BigDecimal price;

    private Date createdTime;

    private Date updatedTime;
}
