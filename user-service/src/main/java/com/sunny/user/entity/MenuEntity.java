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
 * 菜单栏
 *
 * @author JasonLi
 * @date 2019/3/1 19:31
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tm_menu")
@EqualsAndHashCode(callSuper = true)
public class MenuEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(32) comment '菜单名称'", unique = true, nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(32) comment '父id'")
    private String parentId;

    @Column(columnDefinition = "varchar(2000) comment '层级路径'", nullable = false)
    private String path;

    @Column(columnDefinition = "varchar(200) comment '请求路径'")
    private String url;

    /**
     * columnDefinition 用了，length没用
     * 状态
     */
    @Column(columnDefinition = "varchar(10) comment '状态'")
    private ActiveEnum status;

}
