package com.sunny.common.dto;

import cn.hutool.core.util.ArrayUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description: sunny-cloud Page
 * @date: 2019/12/14 11:58 PM
 * @author: JasonLi
 * @version: 1.0
 */
@Data
public class PageDTO {
    private PageDTO(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public static PageDTO of(Integer page, Integer size) {
        return new PageDTO(page, size);
    }

    /**
     * 显示数目
     */
    @NotNull
    @ApiModelProperty(value = "显示数目", required = true)
    @Min(value = 1)
    private Integer size;

    /**
     * 分页页数
     */
    @NotNull
    @ApiModelProperty(value = "分页页数", required = true)
    @Min(value = 1)
    private Integer page;

    /**
     * 排序参数
     */
    @ApiModelProperty(value = "排序参数")
    private String[] properties;

    /**
     * 排序ASC,DESC
     */
    @ApiModelProperty(value = "排序参数")
    private Sort.Direction direction;

    /**
     * 设置初始查询条数为5条
     */
    public Integer getSize() {
        if (size == null || size <= 0) {
            size = 5;
        }
        return size;
    }

    /**
     * 设置初始查询页码为第一页
     */
    public Integer getPage() {
        if (page == null || page <= 0) {
            page = 1;
        }
        return page;
    }


    public Sort.Direction getDirection() {
        if (direction == null) {
            return Sort.Direction.DESC;
        }
        return direction;
    }


    /**
     * 创建分页和排序
     *
     * @return
     */
    @JsonIgnore
    public Pageable getPageable() {
        Pageable pageable;
        if (ArrayUtil.isEmpty(this.properties)) {
            pageable = PageRequest.of(this.page - 1, this.size);
        } else {
            Sort sort = Sort.by(this.getDirection(), this.properties);
            pageable = PageRequest.of(this.page - 1, this.size, sort);
        }
        return pageable;
    }
}
