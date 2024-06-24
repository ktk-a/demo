package com.sj.demo.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateUserRequest {

    private String id;
    private String name;
    private String phone;
    private String nickname;
}
