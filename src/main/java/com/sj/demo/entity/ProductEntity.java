package com.sj.demo.entity;

import jakarta.persistence.Entity;

@Entity(name = "product")
public class ProductEntity {

    private String id;
    private String name;
    private String price;
}
