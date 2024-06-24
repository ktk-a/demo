package com.sj.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "user")
public class UserEntity {
    @Id
    private String id;

    private String name;

    private String phone;

    private String nickname;

    private String password;

    private Date createdTime;

    private Date updatedTime;
}
