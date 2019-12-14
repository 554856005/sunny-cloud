package com.sunny.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * @description: sunny-cloud BaseDTO
 * @date: 2019/12/15 1:29 AM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseDTO extends RootDTO {
    private static final long serialVersionUID = 4531509027374867068L;
    @ApiModelProperty(value = "创建时间")
    private ZonedDateTime createdTime;
    @ApiModelProperty(value = "创建人id")
    private String createdBy;
    @ApiModelProperty(value = "更新时间")
    private ZonedDateTime updatedTime;
    @ApiModelProperty(value = "更新人id")
    private String updatedBy;
}
