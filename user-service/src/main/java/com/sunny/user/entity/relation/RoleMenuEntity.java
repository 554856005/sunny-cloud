package com.sunny.user.entity.relation;

import com.sunny.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: sunny-cloud RoleMenuEntity
 * @date: 2019/12/15 7:34 PM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tr_role_menu")
@EqualsAndHashCode(callSuper = true)
public class RoleMenuEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(32) comment '角色id'", nullable = false)
    private String roleId;
    @Column(columnDefinition = "varchar(32) comment '菜单id'", nullable = false)
    private String menuId;
}
