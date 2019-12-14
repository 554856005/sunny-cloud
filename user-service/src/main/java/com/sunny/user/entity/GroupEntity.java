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
 * 用户组
 *
 * @author JasonLi
 * @date 2019/3/1 20:10
 * @since 1.0
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "tt_group")
@EqualsAndHashCode(callSuper = true)
public class GroupEntity extends BaseEntity {
    @Column(columnDefinition = "varchar(20) comment '名称'")
    private String name;
    /**
     * 使用desc,是mysql中关键字，会导致表不能创建成功
     */
    @Column(columnDefinition = "varchar(1000) comment '描述'")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tr_group_role",
            joinColumns = @JoinColumn(
                    name = "groupId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId", referencedColumnName = "id", columnDefinition = "varchar(36)"
            )
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
