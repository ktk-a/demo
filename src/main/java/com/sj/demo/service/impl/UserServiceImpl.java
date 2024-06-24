package com.sj.demo.service.impl;

import com.sj.demo.dao.UserRepository;
import com.sj.demo.entity.UserEntity;
import com.sj.demo.convertor.UserConverter;
import com.sj.demo.model.PageInfo;
import com.sj.demo.model.request.CreateUserRequest;
import com.sj.demo.model.dto.UserDto;
import com.sj.demo.model.request.FindUserRequest;
import com.sj.demo.model.request.UpdateUserRequest;
import com.sj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        userRepository.save(userEntity);
        return true;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateUser(UpdateUserRequest request) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(request.getId());

        if (!optionalUserEntity.isPresent()) {
            return false;
        }

        UserEntity userEntity = optionalUserEntity.get();

        if (request.getName() != null) {
            userEntity.setName(request.getName());
        }
        if (request.getNickname() != null) {
            userEntity.setNickname(request.getNickname());
        }
        if (request.getPhone() != null) {
            userEntity.setPhone(request.getPhone());
        }

        userRepository.save(userEntity);
        return true;
    }

    @Override
    public UserDto findById(Integer id) {
        return UserConverter.INSTANST.toDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public PageInfo<UserDto> findUsers(FindUserRequest request) {
        UserEntity entity = new UserEntity();

        entity.setName(request.getName());
        entity.setNickname(request.getNickname());
        entity.setPhone(request.getPhone());

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase(true)
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<UserEntity> example = Example.of(entity, matcher);

        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(), sort);

        Page<UserEntity> pageResult = userRepository.findAll(example, pageable);
        List<UserEntity> result = pageResult.get().collect(Collectors.toList());

        PageInfo<UserDto> pageInfo = new PageInfo<>();
        pageInfo.setList(UserConverter.INSTANST.toDtoList(result));
        pageInfo.setTotal(pageResult.getTotalElements());
        return pageInfo;
    }

    @Override
    public List<UserDto> findUsersByMinOrders(String minOrders) {
        List<UserEntity> userEntities = userRepository.findUsersByMinOrders(minOrders);
        return UserConverter.INSTANST.toDtoList(userEntities);
    }

}
