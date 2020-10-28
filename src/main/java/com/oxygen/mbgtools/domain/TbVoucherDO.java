package com.oxygen.mbgtools.domain;

import com.oxygen.mbgtools.mybatis.bean.BaseBean;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TbVoucherDO extends BaseBean {
    /**
     * 
     * 表字段 : tb_voucher.id
     */
    private Integer id;

    /**
     * 代金券名称
     * 表字段 : tb_voucher.name
     */
    private String name;

    /**
     * 代金券价值
     * 表字段 : tb_voucher.price
     */
    private BigDecimal price;

    /**
     * 代金券类型：0：全部可用，1：不可用，2：指定商家，3外卖，4团购券
     * 表字段 : tb_voucher.type
     */
    private Boolean type;

    /**
     * 支付类型 1，所有，2、支付宝，3、银联 4 微信，用,分割
     * 表字段 : tb_voucher.payType
     */
    private String paytype;

    /**
     * 是否已删除，0、未删除，1、已删除
     * 表字段 : tb_voucher.isDelete
     */
    private Boolean isdelete;

    /**
     * 创建时间
     * 表字段 : tb_voucher.createTime
     */
    private LocalDateTime createtime;

    /**
     * 更新时间
     * 表字段 : tb_voucher.updateTime
     */
    private LocalDateTime updatetime;

    /**
     * 代金券截至日期
     * 表字段 : tb_voucher.endTime
     */
    private LocalDateTime endtime;

    /**
     * 
     * 表字段 : tb_voucher.payTypeIcon
     */
    private String paytypeicon;

    /**
     * 代金券说明
     * 表字段 : tb_voucher.voucherdesc
     */
    private String voucherdesc;

    /**
     * 代金券开始日期
     * 表字段 : tb_voucher.startTime
     */
    private LocalDateTime starttime;

    /**
     * 代金券使用范围（0表示全平台）
     * 表字段 : tb_voucher.useRegionId
     */
    private Integer useregionid;

    /**
     * 代金券使用区域名称
     * 表字段 : tb_voucher.useRegionName
     */
    private String useregionname;

    /**
     * 获取  字段:tb_voucher.id
     *
     * @return tb_voucher.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:tb_voucher.id
     *
     * @param id the value for tb_voucher.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 代金券名称 字段:tb_voucher.name
     *
     * @return tb_voucher.name, 代金券名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 代金券名称 字段:tb_voucher.name
     *
     * @param name the value for tb_voucher.name, 代金券名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 代金券价值 字段:tb_voucher.price
     *
     * @return tb_voucher.price, 代金券价值
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置 代金券价值 字段:tb_voucher.price
     *
     * @param price the value for tb_voucher.price, 代金券价值
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取 代金券类型：0：全部可用，1：不可用，2：指定商家，3外卖，4团购券 字段:tb_voucher.type
     *
     * @return tb_voucher.type, 代金券类型：0：全部可用，1：不可用，2：指定商家，3外卖，4团购券
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置 代金券类型：0：全部可用，1：不可用，2：指定商家，3外卖，4团购券 字段:tb_voucher.type
     *
     * @param type the value for tb_voucher.type, 代金券类型：0：全部可用，1：不可用，2：指定商家，3外卖，4团购券
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取 支付类型 1，所有，2、支付宝，3、银联 4 微信，用,分割 字段:tb_voucher.payType
     *
     * @return tb_voucher.payType, 支付类型 1，所有，2、支付宝，3、银联 4 微信，用,分割
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * 设置 支付类型 1，所有，2、支付宝，3、银联 4 微信，用,分割 字段:tb_voucher.payType
     *
     * @param paytype the value for tb_voucher.payType, 支付类型 1，所有，2、支付宝，3、银联 4 微信，用,分割
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    /**
     * 获取 是否已删除，0、未删除，1、已删除 字段:tb_voucher.isDelete
     *
     * @return tb_voucher.isDelete, 是否已删除，0、未删除，1、已删除
     */
    public Boolean getIsdelete() {
        return isdelete;
    }

    /**
     * 设置 是否已删除，0、未删除，1、已删除 字段:tb_voucher.isDelete
     *
     * @param isdelete the value for tb_voucher.isDelete, 是否已删除，0、未删除，1、已删除
     */
    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取 创建时间 字段:tb_voucher.createTime
     *
     * @return tb_voucher.createTime, 创建时间
     */
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:tb_voucher.createTime
     *
     * @param createtime the value for tb_voucher.createTime, 创建时间
     */
    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 更新时间 字段:tb_voucher.updateTime
     *
     * @return tb_voucher.updateTime, 更新时间
     */
    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置 更新时间 字段:tb_voucher.updateTime
     *
     * @param updatetime the value for tb_voucher.updateTime, 更新时间
     */
    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取 代金券截至日期 字段:tb_voucher.endTime
     *
     * @return tb_voucher.endTime, 代金券截至日期
     */
    public LocalDateTime getEndtime() {
        return endtime;
    }

    /**
     * 设置 代金券截至日期 字段:tb_voucher.endTime
     *
     * @param endtime the value for tb_voucher.endTime, 代金券截至日期
     */
    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取  字段:tb_voucher.payTypeIcon
     *
     * @return tb_voucher.payTypeIcon, 
     */
    public String getPaytypeicon() {
        return paytypeicon;
    }

    /**
     * 设置  字段:tb_voucher.payTypeIcon
     *
     * @param paytypeicon the value for tb_voucher.payTypeIcon, 
     */
    public void setPaytypeicon(String paytypeicon) {
        this.paytypeicon = paytypeicon == null ? null : paytypeicon.trim();
    }

    /**
     * 获取 代金券说明 字段:tb_voucher.voucherdesc
     *
     * @return tb_voucher.voucherdesc, 代金券说明
     */
    public String getVoucherdesc() {
        return voucherdesc;
    }

    /**
     * 设置 代金券说明 字段:tb_voucher.voucherdesc
     *
     * @param voucherdesc the value for tb_voucher.voucherdesc, 代金券说明
     */
    public void setVoucherdesc(String voucherdesc) {
        this.voucherdesc = voucherdesc == null ? null : voucherdesc.trim();
    }

    /**
     * 获取 代金券开始日期 字段:tb_voucher.startTime
     *
     * @return tb_voucher.startTime, 代金券开始日期
     */
    public LocalDateTime getStarttime() {
        return starttime;
    }

    /**
     * 设置 代金券开始日期 字段:tb_voucher.startTime
     *
     * @param starttime the value for tb_voucher.startTime, 代金券开始日期
     */
    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取 代金券使用范围（0表示全平台） 字段:tb_voucher.useRegionId
     *
     * @return tb_voucher.useRegionId, 代金券使用范围（0表示全平台）
     */
    public Integer getUseregionid() {
        return useregionid;
    }

    /**
     * 设置 代金券使用范围（0表示全平台） 字段:tb_voucher.useRegionId
     *
     * @param useregionid the value for tb_voucher.useRegionId, 代金券使用范围（0表示全平台）
     */
    public void setUseregionid(Integer useregionid) {
        this.useregionid = useregionid;
    }

    /**
     * 获取 代金券使用区域名称 字段:tb_voucher.useRegionName
     *
     * @return tb_voucher.useRegionName, 代金券使用区域名称
     */
    public String getUseregionname() {
        return useregionname;
    }

    /**
     * 设置 代金券使用区域名称 字段:tb_voucher.useRegionName
     *
     * @param useregionname the value for tb_voucher.useRegionName, 代金券使用区域名称
     */
    public void setUseregionname(String useregionname) {
        this.useregionname = useregionname == null ? null : useregionname.trim();
    }
}