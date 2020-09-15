package com.oxygen.mbgtools.mybatis.bean;

/**
 * @author oxygen
 * @description  分页查询
 * @date 2020/5/7 18:24
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


	/**
	 * 构造分页大小
	 * @param offset
	 * @param limit
	 */
	public Page(Integer offset, Integer limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}


	/**
	 * 初始化
	 */
	public Page() {
		super();
	}


	/**
	 * 默认的分页大小
	 * @return
	 */
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