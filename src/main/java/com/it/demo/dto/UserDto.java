package com.it.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@ToString
public class UserDto {

    @NotNull(message = "id不能null", groups = {Update.class})
    private Integer id;

    @NotNull(message = "name不能null", groups = {Create.class, Update.class})
    private String name;
    private Date createTime;
    private Date updateTime;

    public interface Create {
    }

    public interface Update {
    }

    public interface Query {

    }
}
