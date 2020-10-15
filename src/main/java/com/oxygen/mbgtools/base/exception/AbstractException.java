package com.oxygen.mbgtools.base.exception;

import com.oxygen.mbgtools.enums.StatusCode;

/**
  * Base异常处理
  * @author wangchao
  * @date 2020/9/24 14:31
  * @created by oxygen
  */
public class AbstractException extends RuntimeException {

	private static final long serialVersionUID = 5274301724997391127L;

    private Integer code;

    private Boolean attachErrorCode = true;
    
    /**
     * @author wangchao
     * @date 2020/9/24
     * @param error
     * @param errorMsg
     * @return 
     */
    public AbstractException(StatusCode error, String errorMsg) {
    	String errorMsgStr = attachErrorCode ? errorMsg + "(" + code + ")" : errorMsg;
    	new AbstractException(error.getCode(), errorMsgStr);
    	
    }
    
    /**
     * @author wangchao
     * @date 2020/9/24
     * @param error
     * @return 
     */
    public AbstractException(StatusCode error) {
    	new AbstractException(error.getCode(), error.getMessage());
    }
    
 
    
    /**
     * @author wangchao
     * @date 2020/9/24
     * @param code
     * @param errorMsg
     * @return 
     */
    public AbstractException(Integer code, String errorMsg) {
    	super(errorMsg);
    	this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    
    public void setAttachErrorCode(Boolean b) {
    	this.attachErrorCode = b;
    }
}
