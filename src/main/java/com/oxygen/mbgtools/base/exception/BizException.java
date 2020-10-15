package com.oxygen.mbgtools.base.exception;

import com.oxygen.mbgtools.enums.StatusCode;

/**
  * 业务异常类包装
  * @author Administrator
  * @date 2020/10/15 16:10
  * @created by oxygen
  */
public class BizException extends AbstractException {

	private static final long serialVersionUID = 638307550841159752L;

	/**
	 * BizException
	 * @author wangchao 
	 * @date 2020/10/15
	 * @param code
	 * @param msg
	 * @return 
	 */
	public BizException(Integer code, String msg) {
		super(code, msg);
	}

	
	/**
	 * BizException
	 * @author wangchao 
	 * @date 2020/10/15
	 * @param code
	 * @param msg
	 * @return 
	 */
	public BizException(StatusCode code, String msg) {
		super(code, msg);
	}

	
	/**
	 * BizException
	 * @author wangchao 
	 * @date 2020/10/15
	 * @param code
	 * @return 
	 */
	public BizException(StatusCode code) {
		super(code);
	}
}
