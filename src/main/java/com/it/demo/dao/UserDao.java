package com.it.demo.dao;

import com.it.demo.domain.UserDmo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int createUser(UserDmo userDmo);

    UserDmo querySingle(UserDmo userDmo);
}
