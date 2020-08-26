package com.it.demo.service.impl;

import com.it.demo.dao.EmptDao;
import com.it.demo.domain.Empt;
import com.it.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    public static List<Empt> allEmpt = new ArrayList<>();

    @Autowired
    private EmptDao emptDao;

    @PostConstruct
    public void init() {
        allEmpt = emptDao.getAll();
    }

    @Override
    public List<Empt> getAll() {
        return allEmpt;
    }
}
