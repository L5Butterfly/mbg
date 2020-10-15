package com.oxygen.mbgtools.enums;

/**
 * 异常枚举类
 */
public enum StatusCode {
    //common 
	//TOP error code
	SUCCESS(100, "success"),
	BIZ_FAILED(900, "业务异常"),
	SYSTEM_FAILED(999, "系统异常"),
	
	//below are biz related with the prefix "900"
	
	//the common related 
	//parameter related
    PARAMETER_MISSING_ERROR(900101, "缺少必填参数！"),
    INVALID_PARAMETER_ERROR(900102, "必填参数不能为空！"),
	INVALID_GEO_LOCATION_ERROR(900103, "经纬度不正确！"),
	
    //resource related
	ORDER_NOT_FOUND_ERROR(900104, "订单未找到！"),
	SHOPPER_NOT_FOUND_ERROR(900105, "商家未找到！"),
	USER_NOT_FOUND_ERROR(900106, "用户未找到！"),
	RIDER_NOT_FOUND_ERROR(900107, "骑手未找到！"),
	
	//user account
	INVALID_ACCOUNT_OR_PASSWORD_ERROR(900108, "账号或者密码为空！"),
	INVALID_SHORT_CODE_ERROR(900109, "验证码不正确！"),
	INVALID_TOKEN_EXCEPTION(900110, "Token无效或已过期！"),
	
	
	//configuration related
	CONFIGURATION_MISSING_ERROR(900111, "配置未找到！"),
	CONFIGURATION_FORMAT_INVLIAD_ERROR(900112, "配置格式不正确！"),
	
	//order related
	INVALID_ORDER_STATE_ERROR(900115, "订单状态不正确！"),
		
	//search
	KEYWORD_TOO_SHORT_ERROR(900201, "搜索的字符串太短！"),
	
	
	
	//below are system related, with prefix "999"
	REDIS_CONNECT_TIMEOUT_ERROR(999101, "搜索的字符串太短！"),
	;


    private Integer code;
    private String errorMessage;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.errorMessage = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return errorMessage;
    }

}
