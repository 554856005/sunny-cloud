package com.sunny.user.entity;

import com.sunny.common.entity.BaseEntity;
import com.sunny.common.enums.ActiveEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 数据库命名规则
 * tm = table model
 * tt = table transaction
 * tr = table relation
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
@Table(name = "tt_role")
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(20) comment '角色名称'", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(36) comment '角色编号'")
    private String roleCode;

    @Column(columnDefinition = "varchar(36) comment '角色目录'")
    private String catalog;

    @Column(columnDefinition = "varchar(36) comment '组织Id'", nullable = false)
    private String orgId;

    @Column(columnDefinition = "varchar(1000) comment '描述'")
    private String description;

    @Column(columnDefinition = "varchar(10) comment '状态'")
    private ActiveEnum status;

}
