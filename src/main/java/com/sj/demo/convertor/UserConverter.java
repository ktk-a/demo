package com.sj.demo.convertor;

import com.sj.demo.entity.UserEntity;
import com.sj.demo.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConverter {
    UserConverter INSTANST = Mappers.getMapper(UserConverter.class);

    UserDto toDto(UserEntity userEntity);

    List<UserDto> toDtoList(List<UserEntity> userEntity);
}
