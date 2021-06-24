package com.joker.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Apixxx 就是添加描述的
 */
@ApiModel("user实体类")
public class User {
    @ApiModelProperty("用户名")
    public String name;
    public String password;
}
