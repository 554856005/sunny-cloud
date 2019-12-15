package com.sunny.user.entity;

import com.sunny.common.entity.BaseEntity;
import com.sunny.common.enums.ActiveEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 数据库命名规则
 * tm = table model
 * tt = table transaction
 * tr = table relation
 * 参考：https://blog.csdn.net/Qsir/article/details/72628127
 *
 * @author JasonLi
 * @date 2019/3/1 16:59
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tt_user")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(30) comment '登录名'", unique = true, nullable = false)
    private String loginName;

    @Column(columnDefinition = "varchar(255) comment '登录密码'", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(255) comment '加密盐'")
    private String salt;

    @Column(columnDefinition = "varchar(10) comment '状态'")
    @Enumerated(EnumType.STRING)
    private ActiveEnum status;

    @Column(columnDefinition = "varchar(20) comment '姓名'")
    private String userName;

    @Column(columnDefinition = "tinyint(1) comment '性别，1男、2女'")
    private Integer gender;

    @Column(columnDefinition = "varchar(200) comment '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(20) comment '手机号'")
    private String mobile;

    @Column(columnDefinition = "varchar(20) comment '工号'")
    private String userCode;

    @Column(nullable = false, length = 36)
    private String orgId;
}
