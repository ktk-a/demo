package com.sj.demo.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateUserRequest {

    private String name;
    private String phone;
    private String nickname;
    private String password;

}
