package com.it.demo.controller;

import com.it.demo.dto.QuerySingleEmptParam;
import com.it.demo.dto.QueryUserParam;
import com.it.demo.dto.UserDto;
import com.it.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Validated
public class UserController {

    private final static String SUCCESS_CODE = "0000";
    private final static String FAIL_CODE = "9999";

    @Resource
    private UserService userService;

    @PostMapping(value = "/createUser")
    public String createUser(@RequestBody @Validated(value = UserDto.Create.class) UserDto dto) {
        int createCount = userService.createUser(dto);
        if (createCount > 0) {
            return SUCCESS_CODE;
        } else {
            return FAIL_CODE;
        }
    }
    @PostMapping(value = "/querySingle")
    public UserDto querySingle(@RequestBody @Validated QueryUserParam param){
        return userService.querySingle(param);
    }
}
