package com.sj.demo.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FindUserRequest {

    private String name;
    private String phone;
    private String nickname;

    private int page;
    private int size;
}
