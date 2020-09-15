package com.oxygen.mbgtools.mybatis.bean;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 通用POJO的父类，提供toString方法 
 * @author oxygen
 *
 */
public class BaseBean {

	/**
	 * 日志输出策略格式，稍后讨论决定,类全路径和hashcode没必要输出
	 * @return
	 */
	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
