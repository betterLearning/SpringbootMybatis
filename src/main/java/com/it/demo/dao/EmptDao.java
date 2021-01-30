package com.it.demo.dao;

import com.it.demo.domain.Empt;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface EmptDao {
    List<Empt> getAll();

    Empt selectByPrimaryKey(Integer id);
}
