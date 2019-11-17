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
 * 组织
 *
 * @author JasonLi
 * @date 2019/3/1 19:29
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tt_org")
@EqualsAndHashCode(callSuper = true)
public class OrganizationEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(128) comment '名称'", length = 20)
    private String name;

    @Column(columnDefinition = "varchar(1000) comment '描述'", length = 500)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "organizations")
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
