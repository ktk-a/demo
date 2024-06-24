package com.sj.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private BigDecimal price;

    @Column(insertable = false, updatable = false)
    private Date createdTime;

    @Column(insertable = false, updatable = false)
    private Date updatedTime;
}
