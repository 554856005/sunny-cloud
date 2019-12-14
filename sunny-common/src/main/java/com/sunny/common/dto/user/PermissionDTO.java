package com.sunny.common.dto.user;

import com.sunny.common.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description: sunny-cloud PermissionDTO
 * @date: 2019/12/15 2:06 AM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PermissionDTO extends BaseDTO {
    private static final long serialVersionUID = 1192401000738741493L;
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "权限名字")
    private String name;
    @ApiModelProperty(value = "权限名字")
    private String ename;
    @ApiModelProperty(value = "请求路径")
    private String url;
    @ApiModelProperty(value = "描述")
    private String description;
}
