package com.it.demo.service;

import com.it.demo.dto.QueryUserParam;
import com.it.demo.dto.UserDto;

public interface UserService {
    int createUser(UserDto userDto);

    UserDto querySingle(QueryUserParam param);
}
