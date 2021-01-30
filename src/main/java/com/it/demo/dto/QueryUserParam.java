package com.it.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Setter
@Getter
@ToString
public class QueryUserParam {
    @Min(value = 1)
    @Max(Integer.MAX_VALUE)
    private Integer id;
}
