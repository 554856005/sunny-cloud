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
 * 操作权限
 *
 * @author JasonLi
 * @date 2019/3/1 19:32
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tm_permission")
@EqualsAndHashCode(callSuper = true)
public class PermissionEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(120) comment '权限名称'")
    private String name;
    @Column(columnDefinition = "varchar(120) comment '权限'")
    private String permissions;

    @Column(columnDefinition = "varchar(1000) comment '描述'")
    private String description;

    @Column(columnDefinition = "varchar(10) comment '状态'")
    private ActiveEnum status;

}
