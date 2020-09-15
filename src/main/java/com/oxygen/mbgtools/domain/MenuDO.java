package com.oxygen.mbgtools.domain;

import com.oxygen.mbgtools.mybatis.bean.BaseBean;
import java.time.LocalDateTime;

public class MenuDO extends BaseBean {
    /**
     * 自增序列号
     * 表字段 : menu.id
     */
    private Long id;

    /**
     * 菜单名称
     * 表字段 : menu.name
     */
    private String name;

    /**
     * 父级菜单ID
     * 表字段 : menu.parent_id
     */
    private Long parentId;

    /**
     * 状态
     * 表字段 : menu.status
     */
    private Byte status;

    /**
     * 创建时间
     * 表字段 : menu.create_time
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 表字段 : menu.update_time
     */
    private LocalDateTime updateTime;

    /**
     * 原菜单ID
     * 表字段 : menu.o_id
     */
    private String oId;

    /**
     * 原父级菜单ID
     * 表字段 : menu.o_parent_id
     */
    private String oParentId;

    /**
     * 获取 自增序列号 字段:menu.id
     *
     * @return menu.id, 自增序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增序列号 字段:menu.id
     *
     * @param id the value for menu.id, 自增序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 菜单名称 字段:menu.name
     *
     * @return menu.name, 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 菜单名称 字段:menu.name
     *
     * @param name the value for menu.name, 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 父级菜单ID 字段:menu.parent_id
     *
     * @return menu.parent_id, 父级菜单ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置 父级菜单ID 字段:menu.parent_id
     *
     * @param parentId the value for menu.parent_id, 父级菜单ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 状态 字段:menu.status
     *
     * @return menu.status, 状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置 状态 字段:menu.status
     *
     * @param status the value for menu.status, 状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取 创建时间 字段:menu.create_time
     *
     * @return menu.create_time, 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:menu.create_time
     *
     * @param createTime the value for menu.create_time, 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间 字段:menu.update_time
     *
     * @return menu.update_time, 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:menu.update_time
     *
     * @param updateTime the value for menu.update_time, 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 原菜单ID 字段:menu.o_id
     *
     * @return menu.o_id, 原菜单ID
     */
    public String getoId() {
        return oId;
    }

    /**
     * 设置 原菜单ID 字段:menu.o_id
     *
     * @param oId the value for menu.o_id, 原菜单ID
     */
    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    /**
     * 获取 原父级菜单ID 字段:menu.o_parent_id
     *
     * @return menu.o_parent_id, 原父级菜单ID
     */
    public String getoParentId() {
        return oParentId;
    }

    /**
     * 设置 原父级菜单ID 字段:menu.o_parent_id
     *
     * @param oParentId the value for menu.o_parent_id, 原父级菜单ID
     */
    public void setoParentId(String oParentId) {
        this.oParentId = oParentId == null ? null : oParentId.trim();
    }
}