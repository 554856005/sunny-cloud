package com.sunny.user.entity;

import com.sunny.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    /**
     * 姓名
     */
    @Column(columnDefinition = "varchar(20) comment '姓名'")
    private String userName;

    /**
     * 工号
     */
    @Column(columnDefinition = "varchar(20) comment '工号'")
    private String userCode;

    /**
     * 登录名
     */
    @Column(columnDefinition = "varchar(30) comment '登录名'", unique = true, nullable = false)
    private String loginName;

    /**
     * 登录密码
     */
    @Column(columnDefinition = "varchar(255) comment '登录密码'")
    private String password;

    /**
     * 加密盐
     */
    @Column(columnDefinition = "varchar(255) comment '加密盐'")
    private String salt;

    /**
     * 组织id
     */
    @Column(nullable = false, length = 36)
    private String orgId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tr_user_role",
            joinColumns = @JoinColumn(
                    name = "userId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            )
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
