package com.sunny.user.entity;

import com.sunny.common.entity.BaseEntity;
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
    /**
     * 角色名称
     */
    @Column(columnDefinition = "varchar(20) comment '角色名称'", nullable = false)
    private String name;

    /**
     * 角色代码
     */
    @Column(columnDefinition = "varchar(36) comment '角色代码'")
    private String roleCode;

    /**
     * 角色目录
     */
    @Column(columnDefinition = "varchar(36) comment '角色目录'")
    private String catalog;

    /**
     * 所在组织Id
     */
    @Column(columnDefinition = "varchar(36) comment '组织Id'")
    private String orgId;

    /**
     * 描述
     */
    @Column(columnDefinition = "varchar(1000) comment '描述'")
    private String description;

    /**
     * 状态
     */
    @Column(columnDefinition = "varchar(10) comment '状态'")
    private ActiveEnum status;

    /**
     * mappedBy roles,主动性在用户和组织，他们具有添加删除角色的权利
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<GroupEntity> groups = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tr_role_org",
            joinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "orgId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            )
    )
    private Set<OrganizationEntity> organizations = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tr_role_permission",
            joinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "permissionId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            )
    )
    private Set<PermissionEntity> permissions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tr_role_menu",
            joinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "menuId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            )
    )
    private Set<MenuEntity> menus = new HashSet<>();


    public void addMenu(MenuEntity menu) {
        this.menus.add(menu);
    }

    public void deleteMenu(MenuEntity menu) {
        this.menus.remove(menu);
    }

    public void addUser(UserEntity user) {
        this.users.add(user);
    }

    public void deleteUser(UserEntity user) {
        this.users.remove(user);
    }

    public void addPermission(PermissionEntity permission) {
        this.permissions.add(permission);
    }

    public void deletePermission(PermissionEntity permission) {
        this.permissions.remove(permission);
    }
}
