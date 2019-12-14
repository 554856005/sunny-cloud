package com.sunny.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: sunny-cloud RootDTO
 * @date: 2019/12/15 1:29 AM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@NoArgsConstructor
public class RootDTO implements Serializable {
    private static final long serialVersionUID = -6850032350784603706L;
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "版本号")
    private Long version;
}
