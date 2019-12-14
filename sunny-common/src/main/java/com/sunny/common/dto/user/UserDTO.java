package com.sunny.common.dto.user;

import com.sunny.common.dto.BaseDTO;
import com.sunny.common.enums.ActiveEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description: sunny-cloud UserDTO
 * @date: 2019/12/15 1:25 AM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {
    private static final long serialVersionUID = -3203151288411457005L;
    @ApiModelProperty(value = "登录名称")
    private String loginName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "性别（1男 2女）")
    private Integer gender;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "是否启用（1启用，99禁用）")
    private ActiveEnum status;
}
