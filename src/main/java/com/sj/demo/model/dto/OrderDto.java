package com.sj.demo.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDto {
    private Integer oid;

    private Integer uid;

    private Integer pid;

    private String productName;

    private BigDecimal price;

    private Date createdTime;

    private Date updatedTime;
}
