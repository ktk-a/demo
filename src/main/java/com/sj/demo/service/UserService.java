package com.sj.demo.service;

import com.sj.demo.model.request.CreateUserRequest;
import com.sj.demo.model.dto.UserDto;
import com.sj.demo.model.request.FindUserRequest;
import com.sj.demo.model.request.UpdateUserRequest;

import java.util.List;

public interface UserService {

    public boolean createUser(CreateUserRequest request);

    public boolean deleteUserById(String id);

    public boolean updateUser(UpdateUserRequest request);

    public UserDto findById(String id);

    public List<UserDto> findUsers(FindUserRequest request);
}
