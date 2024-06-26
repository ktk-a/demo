package com.sj.demo.controller;

import com.sj.demo.model.PageInfo;
import com.sj.demo.model.request.CreateUserRequest;
import com.sj.demo.model.request.FindUserRequest;
import com.sj.demo.model.request.UpdateUserRequest;
import com.sj.demo.model.dto.UserDto;
import com.sj.demo.result.HttpResponseResult;
import com.sj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public HttpResponseResult<PageInfo<UserDto>> findUser(@RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String phone,
                                                          @RequestParam(required = false) String nickName,
                                                          @RequestParam(defaultValue = "1") int page,
                                                          @RequestParam(defaultValue = "10") int size) {

        FindUserRequest request = new FindUserRequest();
        request.setName(name);
        request.setPhone(phone);
        request.setNickname(nickName);
        request.setName(name);
        request.setSize(size);
        request.setPage(page);

        return HttpResponseResult.success(userService.findUsers(request));
    }

    @GetMapping("/{id}")
    public HttpResponseResult<UserDto> findUserById(@PathVariable(value = "id") Integer id) {
        return HttpResponseResult.success(userService.findById(id));
    }

    @PostMapping("")
    public HttpResponseResult<Boolean> createUser(@RequestBody CreateUserRequest request) {
        return HttpResponseResult.success(userService.createUser(request));
    }

    @DeleteMapping("/{id}")
    public HttpResponseResult<Boolean> deleteUser(@PathVariable(value = "id") Integer id) {
        return HttpResponseResult.success(userService.deleteUserById(id));
    }

    @PutMapping("/{id}")
    public HttpResponseResult<Boolean> updateUser(@RequestBody UpdateUserRequest request) {
        return HttpResponseResult.success(userService.updateUser(request));
    }

    @GetMapping("orders/statistics")
    public HttpResponseResult<List<UserDto>> statistics(@RequestParam String minOrders) {
        return HttpResponseResult.success(userService.findUsersByMinOrders(minOrders));
    }
}
