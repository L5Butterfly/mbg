package com.oxygen.mbgtools.commom;


/**
 * @author oxygen
 * @description TransactionParam事务错误信息包装类
 * @date 2020/5/8 16:02
 **/
public class TransactionParam {
	/**响应码*/
	private String code;
	/**响应信息*/
	private String msg;
	/**描述信息*/
	private String desc;
	
	public TransactionParam() {
		super();
	}
	public TransactionParam(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public TransactionParam(String code, String msg, String desc) {
		super();
		this.code = code;
		this.msg = msg;
		this.desc = desc;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "TransactionParam [code=" + code + ", msg=" + msg + ", desc=" + desc + "]";
	}
}
