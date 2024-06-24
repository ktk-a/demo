package com.sj.demo.mapper;

import com.sj.demo.entity.UserEntity;
import com.sj.demo.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANST = Mappers.getMapper(UserMapper.class);

    UserDto toDto(UserEntity userEntity);
    List<UserDto> toDtoList(List<UserEntity> userEntity);
}
