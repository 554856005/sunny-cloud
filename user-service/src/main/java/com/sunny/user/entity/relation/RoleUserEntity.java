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
 * @description: sunny-cloud RoleUserEntity
 * @date: 2019/12/15 7:35 PM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tr_role_user")
@EqualsAndHashCode(callSuper = true)
public class RoleUserEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(32) comment '角色id'", nullable = false)
    private String roleId;
    @Column(columnDefinition = "varchar(32) comment '用户id'", nullable = false)
    private String userId;
}
