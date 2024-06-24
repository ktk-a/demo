package com.sj.demo.service.impl;

import com.sj.demo.dao.UserRepository;
import com.sj.demo.entity.UserEntity;
import com.sj.demo.mapper.UserMapper;
import com.sj.demo.model.request.CreateUserRequest;
import com.sj.demo.model.dto.UserDto;
import com.sj.demo.model.request.FindUserRequest;
import com.sj.demo.model.request.UpdateUserRequest;
import com.sj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(CreateUserRequest request) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setNickname(request.getNickname());
        userEntity.setPhone(request.getPhone());
        userEntity.setPassword(request.getPassword());

        userRepository.save(userEntity);
        return true;
    }

    @Override
    public boolean deleteUserById(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateUser(UpdateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(request.getId());
        userEntity.setName(request.getName());
        userEntity.setNickname(request.getNickname());
        userEntity.setPhone(request.getPhone());
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public UserDto findById(String id) {
        return UserMapper.INSTANST.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UserDto> findUsers(FindUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setPhone(request.getPhone());
        entity.setName(request.getName());
        entity.setNickname(request.getNickname());

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<UserEntity> example = Example.of(entity, matcher);

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Page<UserEntity> pageResult = userRepository.findAll(example, pageable);
        List<UserEntity> result = pageResult.get().collect(Collectors.toList());
        return UserMapper.INSTANST.toDtoList(result);
    }

}
