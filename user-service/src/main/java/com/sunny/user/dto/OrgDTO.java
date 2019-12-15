package com.sunny.user.dto;

import com.sunny.common.dto.RootDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: sunny-cloud OrgDTO
 * @date: 2019/12/15 6:06 PM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrgDTO extends RootDTO {
    private static final long serialVersionUID = 1462172542879609613L;
    @ApiModelProperty(value = "名称'")
    private String name;

    @ApiModelProperty(value = "父id'")
    private String parentId;

    @ApiModelProperty(value = "层级路径")
    private String path;

    @ApiModelProperty(value = "描述")
    private String description;
}
