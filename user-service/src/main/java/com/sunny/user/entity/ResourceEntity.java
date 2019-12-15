package com.sunny.user.entity;

import com.sunny.common.entity.BaseEntity;
import com.sunny.user.enums.ResourceEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @description: sunny-cloud ResourceEntity
 * @date: 2019/12/15 7:36 PM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tm_resource")
@EqualsAndHashCode(callSuper = true)
public class ResourceEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(255) comment '资源类型'")
    @Enumerated(EnumType.STRING)
    private ResourceEnum resourceType;

    @Lob
    @Column(columnDefinition = "longtext comment '资源值'")
    private String resources;
}
