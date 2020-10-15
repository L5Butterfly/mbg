package com.oxygen.mbgtools.base.r;

 /**
  * 类信息注释
  * @author wangchao
  * @date 2020/10/15 16:23
  * @created by oxygen
  */
public class DataResultBuilder {

	/**
	 * HTTP协议controller接口调用系统异常
	 *
	 * @return ResultObj
	 */
	public static DataResult createSystemExceptionResult(DataResult result,String msg) {
		if(result == null) {
			result = new DataResult();
		}
		result.setCode("000");
		result.setMsg(msg);
		return result;
	}
}
