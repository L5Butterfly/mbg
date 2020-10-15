package com.oxygen.mbgtools.base.exception;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
  * 业务异常类
  * @author wangchao
  * @date 2020/9/17 11:28
  * @created by oxygen
  */
public class VehicleException extends CommonException {

	private static final long serialVersionUID = -178175315328712658L;

	/**
	 * 业务异常构造
	 * @param code  业务异常枚举值
	 */
	public VehicleException(VehicleErrorEnum code) {
		super(code.getCode(), code.getMsg(), code.getMsg());
	}

	/**
	 * 业务异常构造
	 * @param code  业务异常枚举值
	 * @param message  基类RuntimeException异常信息构造入参
	 */
	public VehicleException(VehicleErrorEnum code, String message) {
		super(code.getCode(), code.getMsg(), message);
	}

	/**
	 * 业务异常构造
	 * @param code   业务异常枚举值
	 * @param cause  基类RuntimeException异常Throwable构造入参
	 */
	public VehicleException(VehicleErrorEnum code, Throwable cause) {
		super(code.getCode(), code.getMsg(), cause);
	}

	/**
	 * 业务异常构造
	 * @param code  业务异常枚举值
	 * @param message  基类RuntimeException异常信息构造入参
	 * @param cause  基类RuntimeException异常Throwable构造入参
	 */
	public VehicleException(VehicleErrorEnum code, String message, Throwable cause) {
		super(code.getCode(), code.getMsg(), message, cause);
	}

	/**
	 * 业务异常构造
	 * @param code   业务错误码
	 * @param msg  业务错描述
	 * @param cause  基类RuntimeException异常Throwable构造入参
	 */
	public VehicleException(String code, String msg, Throwable cause) {
		super(code, msg, cause);
	}


	/**
	 * 业务异常构造
	 * @param code  业务错误码
	 * @param msg  业务错描述
	 */
	public VehicleException(String code, String msg) {
		super(code, msg);
	}


	/**
	 * 获取动态业务错误信息
	 * @param code   业务异常枚举值
	 * @param objs  动态参数
	 * @return
	 */
	public static VehicleException builderDynamicException(VehicleErrorEnum code, Object... objs) {
		String msg = CommonException.replace(code.getMsg(), objs);
		return new VehicleException(code.getCode(), msg);
	}

	/**
	 * 动态设置错误信息
	 * @param errorMsg   业务错误信息
	 * @param objs   动态参数
	 * @return
	 */
	public static VehicleException builderDynamicException(String errorMsg, Object... objs) {
		String msg = VehicleException.replaceStr(errorMsg, objs);
		return new VehicleException(VehicleErrorEnum.BIZ_ERROR.getCode(), msg);
	}


	/**
	 * 替换响应码消息中的占位符{}
	 *
	 * @param msg  响应码消息
	 * @param objs 替换参数
	 * @return 替换后的响应码消息
	 */
	public static String replaceStr(String msg, Object... objs) {
		if (objs == null) {
			return msg;
		}
		for (Object obj : objs) {
			msg = msg.replaceFirst(FORMAT, ObjectUtils.defaultIfNull(obj, StringUtils.EMPTY).toString());
		}
		return msg;
	}

	/**********************其他业务异常实例构建***********************************/

	/**
	 * 设置自定义枚举异常
	 * @author wangchao 
	 * @date 2020/10/13
	 * @param code 业务异常枚举值
	 * @return VehicleException
	 */
	public static VehicleException builderException(VehicleErrorEnum code){
		return new VehicleException(code);
	}



	/**
	 * 设置自定义枚举异常
	 * @author wangchao 
	 * @date 2020/10/13
	 * @param code   业务异常枚举值
	 * @param message  基类Exception(Throwable)异常信息输出
	 * @return VehicleException
	 */
	public VehicleException builderException(VehicleErrorEnum code, String message) {
		return new VehicleException(code,message);
	}
}