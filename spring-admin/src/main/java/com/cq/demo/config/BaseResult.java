package com.cq.demo.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: ChengYangChang
 */
@ApiModel(value = "返回说明")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BaseResult<T> {

    @ApiModelProperty(value = "成功标识")
    private boolean success;

    @ApiModelProperty(value = "返回状态码")
    private int code;

    @ApiModelProperty(value = "描述信息")
    private String message;

    private T data;

}
