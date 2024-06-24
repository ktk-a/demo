package com.sj.demo.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "user")
public class UserEntity {
    private String id;
    private String name;
    private String phone;
    private String nickname;
    private String password;
}
