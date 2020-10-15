package com.oxygen.mbgtools.enums;

/**
 * 响应码列表，按照规范编排对应的响应码
 * 2位系统编码 + 2位模块编码 + 1位类型编码 + 1位分级编码 + 2位顺序号
 * 分级编码0代表默认，1代表信息，2代表告警，3代表错误
 * 类型编码
 * 1 用户输入参数错误
 * 2 数据库操作失败
 * 3 其他运行异常
 * 4 远程调用异常
 * 5、6、7 保留
 * 8 异常记录
 * 9 特殊情况
 * @author emapthy
 *
 */
public enum CommonCodeEnum {

    /**
     *  前端上传文件的组件认为后端返回0时是成功的,为兼容前端组件,所以增加一个成功的枚举值
     *  注: 不建议直接使用此值, 添加到这里是为了告诉大家不要用"0"来表示失败
     */
    SUCCESS_ZERO("0", "成功"),
    SUCCESS("00000000", "成功"),
    /**数据库异常*/
    DB_EXCEPTION("40000000", "数据库操作异常!"),
    /**其他运行异常*/
    RUNTIME_ERROR("50000000", "其他运行异常"),
    ;


    private String code;
	private String msg;
	private CommonCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
