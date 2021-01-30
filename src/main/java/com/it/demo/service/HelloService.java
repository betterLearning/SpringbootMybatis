package com.it.demo.service;


import com.it.demo.domain.Empt;
import com.it.demo.dto.QuerySingleEmptParam;

import java.util.List;

public interface HelloService {

    List<Empt> getAll();

    Empt getSingleEmpt(QuerySingleEmptParam param);
}
