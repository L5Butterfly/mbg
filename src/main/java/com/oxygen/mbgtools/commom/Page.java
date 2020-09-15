package com.oxygen.mbgtools.commom;


/**
 * 数据分页类
 * @author oxygen
 * @date 2020/7/6
 **/
public class Page {

    /**分页查询开始记录位置*/
    private Integer offset;
    /**每页显示记录数*/
    private Integer limit;
    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public Page(Integer offset, Integer limit) {
        super();
        this.offset = offset;
        this.limit = limit;
    }
    public Page() {
        super();
    }
    public static Page getDefault() {
        Page page = new Page();
        page.setLimit(20);
        page.setOffset(0);
        return page;
    }
    @Override
    public String toString() {
        return "Page [offset=" + offset + ", limit=" + limit + "]";
    }
}
