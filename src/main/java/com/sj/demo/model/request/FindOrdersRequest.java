package com.sj.demo.model.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Accessors(chain = true)
public class FindOrdersRequest {

    private Integer oid;
    private String productName;
    private String startDate;
    private String endDate;
    private int page;
    private int size;
}
