package com.sj.demo.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateOrderRequest {

    private Integer uid;
    private Integer pid;
}
