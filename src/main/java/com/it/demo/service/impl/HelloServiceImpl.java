package com.it.demo.service.impl;

import com.it.demo.dao.EmptDao;
import com.it.demo.domain.Empt;
import com.it.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private EmptDao emptDao;

    @Override
    public List<Empt> getAll() {
        return emptDao.getAll();
    }
}
