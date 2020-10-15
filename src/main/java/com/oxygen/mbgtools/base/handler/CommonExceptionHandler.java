package com.oxygen.mbgtools.base.handler;

import com.oxygen.mbgtools.base.constants.CommonConstants;
import com.oxygen.mbgtools.base.exception.AbstractException;
import com.oxygen.mbgtools.base.exception.VehicleErrorEnum;
import com.oxygen.mbgtools.base.exception.VehicleException;
import com.oxygen.mbgtools.base.r.DataResult;
import com.oxygen.mbgtools.base.r.DataResultBuilder;
import com.oxygen.mbgtools.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller层拦截异常并统一处理
 * @author Administrator
 * @date 2020/9/24 14:34
 * @created by oxygen
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.oxygen.mbgtools.controller"})
public class CommonExceptionHandler {

   /**
	* AbstractException异常处理
	* @author wangchao
	* @date 2020/10/13
	* @param ex
	* @return com.bjj.access.modal.ResultObj
	*/
   @ExceptionHandler(AbstractException.class)
   public DataResult handleAbstractExceptionHandler(AbstractException ex){
	   log.info("CommonExceptionHandler.AbstractException, errorCode:{}, errorMsg:{}, ex:{}",ex.getCode(),ex.getMessage(),StringUtil.getLog(ex));
	   System.out.println( StringUtil.getLog(ex));
	   DataResult resultObj = new DataResult();
	   resultObj.setMsg(ex.getMessage());
	   resultObj.setCode(ex.getCode().toString());
	   return resultObj;
   }


   /**
	* Exception异常处理
	* @author wangchao
	* @date 2020/10/13
	* @param ex
	* @return com.bjj.access.modal.ResultObj
	*/
   @ExceptionHandler(Exception.class)
   public DataResult handleExceptionHandler(Exception ex){
	   log.info("CommonExceptionHandler.Exception, Exception error:{}",StringUtil.getLog(ex));
	   DataResult resultObj = new DataResult();
	   DataResultBuilder.createSystemExceptionResult(resultObj, CommonConstants.MSG_SYSTEM_EXCEPTION);
	   return resultObj;
   }


   /**
	* 自定义VehicleException异常全局拦截
	* @author wangchao
	* @date 2020/10/13
	* @param ex 自定义异常：VehicleException
	* @return com.bjj.access.modal.ResultObj
	*/
	@ExceptionHandler(VehicleException.class)
	public DataResult handleAbstractExceptionHandler(VehicleException ex){
		log.info("CommonExceptionHandler.VehicleException, errorCode:{}, errorMsg:{}, ex:{}",ex.getCode(),ex.getMessage(), StringUtil.getLog(ex));
		DataResult resultObj = new DataResult();
		resultObj.setMsg(ex.getMessage());
		resultObj.setCode(VehicleErrorEnum.BIZ_FAILED.getCode());
		return resultObj;
	}

}
