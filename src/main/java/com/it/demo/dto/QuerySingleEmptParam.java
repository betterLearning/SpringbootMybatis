package com.it.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author gzh
 */
@Setter
@Getter
@ToString
public class QuerySingleEmptParam {
    @Min(value = 1)
    @Max(Integer.MAX_VALUE)
    private Integer id;
}
