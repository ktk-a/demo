package com.sj.demo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity(name = "order")
public class OrderEntity {

    private String oid;

    private String uid;

    private String pid;

    private BigDecimal price;
}
