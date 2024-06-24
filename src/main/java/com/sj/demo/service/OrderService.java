package com.sj.demo.service;

import com.sj.demo.model.PageInfo;
import com.sj.demo.model.dto.OrderDto;
import com.sj.demo.model.request.CreateOrderRequest;
import com.sj.demo.model.request.FindOrdersRequest;

public interface OrderService {

    public boolean createOrder(CreateOrderRequest request);

    public PageInfo<OrderDto> findOrders(FindOrdersRequest request);
}
