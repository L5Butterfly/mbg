package com.oxygen.mbgtools.domain;

import com.oxygen.mbgtools.mybatis.bean.BaseBean;
import java.time.LocalDateTime;

public class RoleDO extends BaseBean {
    /**
     * 自增序列号
     * 表字段 : role.id
     */
    private Long id;

    /**
     * 角色名称
     * 表字段 : role.name
     */
    private String name;

    /**
     * 状态
     * 表字段 : role.status
     */
    private Boolean status;

    /**
     * 级别
     * 表字段 : role.level
     */
    private Integer level;

    /**
     * 创建时间
     * 表字段 : role.create_time
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 表字段 : role.update_time
     */
    private LocalDateTime updateTime;

    /**
     * 获取 自增序列号 字段:role.id
     *
     * @return role.id, 自增序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增序列号 字段:role.id
     *
     * @param id the value for role.id, 自增序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 角色名称 字段:role.name
     *
     * @return role.name, 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 角色名称 字段:role.name
     *
     * @param name the value for role.name, 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 状态 字段:role.status
     *
     * @return role.status, 状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置 状态 字段:role.status
     *
     * @param status the value for role.status, 状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 级别 字段:role.level
     *
     * @return role.level, 级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置 级别 字段:role.level
     *
     * @param level the value for role.level, 级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取 创建时间 字段:role.create_time
     *
     * @return role.create_time, 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:role.create_time
     *
     * @param createTime the value for role.create_time, 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间 字段:role.update_time
     *
     * @return role.update_time, 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:role.update_time
     *
     * @param updateTime the value for role.update_time, 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}