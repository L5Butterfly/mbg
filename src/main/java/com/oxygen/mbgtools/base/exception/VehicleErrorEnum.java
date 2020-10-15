package com.oxygen.mbgtools.base.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 车型业务错误码
 *
 * @author wangchao
 * @date 2020/9/17 11:32
 * @created by oxygen
 */
@AllArgsConstructor
public enum VehicleErrorEnum {

	/** 基础错误**/
	SYSTEM_INFO_ERROR("20180101", "错误码示例"),
	SYSTEM_ERROR("20180102", "错误码示例"),
	SUCCESS("100", "success"),
	BIZ_FAILED("900", "业务异常"),
	SYSTEM_FAILED("999", "系统异常"),
	/** 用的业务错误**/
	BIZ_ERROR("20200901", "出行业务处理错误"),
	CONFIG_KEY_ERROR("20200901", "配置数据key不存在"),
	CAR_NO_CONFIG_FREE_RULE("2020101301","车辆没有配置费用规则"),
	QUERY_PAGE_NUMBER_ERROR("2020101302","pageNo参数不合法,分页必须大于0"),
	;

	@Getter
	private final String code;

	@Getter
	private final String msg;

}
