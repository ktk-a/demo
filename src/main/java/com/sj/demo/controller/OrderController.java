package com.sj.demo.controller;

import com.sj.demo.model.PageInfo;
import com.sj.demo.model.dto.OrderDto;
import com.sj.demo.model.request.CreateOrderRequest;
import com.sj.demo.model.request.FindOrdersRequest;
import com.sj.demo.result.HttpResponseResult;
import com.sj.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public HttpResponseResult<Boolean> createOrder(@RequestBody CreateOrderRequest request) {
        return HttpResponseResult.success(orderService.createOrder(request));
    }

    @GetMapping("")
    public HttpResponseResult<PageInfo<OrderDto>> findOrders(@RequestParam(required = false) Integer oid,
                                                             @RequestParam(required = false) String productName,
                                                             @RequestParam(required = false) String startDate,
                                                             @RequestParam(required = false) String endDate,
                                                             @RequestParam(defaultValue = "1") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        FindOrdersRequest request = new FindOrdersRequest();
        request.setOid(oid);
        request.setProductName(productName);
        request.setStartDate(startDate);
        request.setEndDate(endDate);
        request.setPage(page);
        request.setSize(size);

        return HttpResponseResult.success(orderService.findOrders(request));
    }
}
