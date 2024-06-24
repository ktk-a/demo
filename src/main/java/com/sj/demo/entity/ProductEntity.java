package com.sj.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name = "product")
public class ProductEntity {
    @Id
    private String id;

    private String name;

    private String price;

    private Date createdTime;

    private Date updatedTime;
}
