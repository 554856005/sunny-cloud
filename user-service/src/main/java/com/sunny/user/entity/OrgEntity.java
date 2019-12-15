package com.sunny.user.entity;

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
public class OrgEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(128) comment '名称'", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(32) comment '父id'")
    private String parentId;

    @Column(columnDefinition = "varchar(2000) comment '层级路径'", nullable = false)
    private String path;

    @Column(columnDefinition = "varchar(1000) comment '描述'")
    private String description;

}
