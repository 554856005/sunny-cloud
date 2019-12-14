package com.sunny.user.entity;

import com.sunny.common.entity.RootEntity;
import com.sunny.common.enums.ActiveEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
public class MenuEntity extends RootEntity {
    /**
     * 菜单名称
     */
    @Column(unique = true, nullable = false, length = 20)
    private String name;

    /**
     * columnDefinition 用了，length没用
     * 状态
     */
    @Column(columnDefinition = "varchar(10) comment '状态'")
    private ActiveEnum status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menus")
    private Set<RoleEntity> roleEntities = new HashSet<>();
}
