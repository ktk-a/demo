package com.sj.demo.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Integer id;

    private String name;

    private String phone;

    private String nickname;

    private Date createdTime;

    private Date updatedTime;
}
