package com.sj.demo.service.impl;

import com.sj.demo.convertor.OrderConverter;
import com.sj.demo.dao.OrderRepository;
import com.sj.demo.dao.ProductRepository;
import com.sj.demo.dao.UserRepository;
import com.sj.demo.entity.OrderEntity;
import com.sj.demo.entity.ProductEntity;
import com.sj.demo.entity.UserEntity;
import com.sj.demo.model.PageInfo;
import com.sj.demo.model.dto.OrderDto;
import com.sj.demo.model.request.CreateOrderRequest;
import com.sj.demo.model.request.FindOrdersRequest;
import com.sj.demo.service.OrderService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean createOrder(CreateOrderRequest request) {

        Optional<UserEntity> optionalUserEntity = userRepository.findById(request.getUid());
        if (!optionalUserEntity.isPresent()) {
            return false;
        }

        Optional<ProductEntity> optionalProductEntity = productRepository.findById(request.getPid());
        if (!optionalProductEntity.isPresent()) {
            return false;
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUid(request.getUid());
        orderEntity.setPid(request.getPid());
        orderEntity.setProductName(optionalProductEntity.get().getName());
        orderEntity.setPrice(optionalProductEntity.get().getPrice());

        orderRepository.save(orderEntity);

        return true;
    }

    @Override
    public PageInfo<OrderDto> findOrders(FindOrdersRequest request) {
        Specification<OrderEntity> spec = (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (request.getProductName() != null) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("productName")), "%" + request.getProductName().toLowerCase() + "%"));
            }

            if (request.getOid() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("oid"), request.getOid()));
            }

            if (request.getStartDate() != null && request.getEndDate() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime startDateTime = LocalDate.parse(request.getStartDate(), formatter).atStartOfDay();
                LocalDateTime endDateTime = LocalDate.parse(request.getEndDate(), formatter).plusDays(1).atStartOfDay();
                predicate = cb.and(predicate, cb.between(root.get("createdTime"), startDateTime, endDateTime));
            }
            return predicate;
        };
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.Direction.DESC, "createdTime");

        Page<OrderEntity> pageResult = orderRepository.findAll(spec, pageable);
        List<OrderEntity> result = pageResult.getContent();

        PageInfo<OrderDto> pageInfo = new PageInfo<>();
        pageInfo.setList(OrderConverter.INSTANST.toDtoList(result));
        pageInfo.setTotal(pageResult.getTotalElements());
        return pageInfo;
    }
}
