package com.sj.demo.convertor;

import com.sj.demo.entity.OrderEntity;
import com.sj.demo.model.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderConverter {
    OrderConverter INSTANST = Mappers.getMapper(OrderConverter.class);

    OrderDto toDto(OrderEntity orderEntity);

    List<OrderDto> toDtoList(List<OrderEntity> orderEntity);
}
