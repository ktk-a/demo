package com.sj.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String phone;

    private String nickname;

    @Column(insertable = false, updatable = false)
    private Date createdTime;

    @Column(insertable = false, updatable = false)
    private Date updatedTime;
}
