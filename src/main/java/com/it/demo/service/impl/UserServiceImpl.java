package com.it.demo.service.impl;

import com.it.demo.dao.UserDao;
import com.it.demo.domain.UserDmo;
import com.it.demo.dto.QueryUserParam;
import com.it.demo.dto.UserDto;
import com.it.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int createUser(UserDto userDto) {
        UserDmo dmo = new UserDmo();
        BeanUtils.copyProperties(userDto,dmo);
        return userDao.createUser(dmo);
    }

    @Override
    public UserDto querySingle(QueryUserParam param) {
        UserDmo dmo = new UserDmo();
        dmo.setId(param.getId());
        UserDmo returnDmo = userDao.querySingle(dmo);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(returnDmo,dto);
        return dto;
    }
}
