package com.oxygen.mbgtools.base.interruptor;

import com.oxygen.mbgtools.base.annotation.ApiLogRegister;
import com.oxygen.mbgtools.base.constants.NumberConstants;
import com.oxygen.mbgtools.base.exception.VehicleException;
import com.oxygen.mbgtools.base.exception.VehicleErrorEnum;
import com.oxygen.mbgtools.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 统一接口日志拦截
 *
 * @author wangchao
 * @date 2020/9/17 14:32
 * @created by oxygen
 */
@Slf4j
@Aspect
@Component
public class ApiReqLogAspect {

	/**
	 * SpringBoot获取当前环境代码,Spring获取当前环境代码
	 */
	@Value("${spring.profiles.active}")
	private String profiles;


	/**
	 * 生产环境(pre,prd,根据版本轮流变化)
	 */
	private static final String PRODUCTION_ENV="pre,prd,test";


	@Around("@annotation(com.oxygen.mbgtools.base.annotation.ApiLogRegister)")
	public Object recordRequestLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		Signature sig = proceedingJoinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) sig;
		ApiLogRegister logSign = methodSignature.getMethod().getAnnotation(ApiLogRegister.class);
		String method = logSign.name();
		String param = StringUtils.EMPTY;

		try {
			//判断是否是生产环境，生产环境不打印日志
			if (profiles.contains(PRODUCTION_ENV)) {
				Object obj = proceedingJoinPoint.proceed();
				return obj;
			}
			method = logSign.name();
			if (proceedingJoinPoint.getArgs() != null && proceedingJoinPoint.getArgs().length > NumberConstants.ZERO) {
				param = generateInputParam(proceedingJoinPoint.getArgs());
			}
			Object obj = proceedingJoinPoint.proceed();
			try {
				String resultStr = StringUtils.EMPTY;
				if (obj != null) {
					resultStr = JsonUtil.toJson(obj);
				}
				log.info("ApiReqLogAspect, action={}, request={}, response={}", method, param, resultStr);
			} catch (Exception e) {
				//这个异常应该吃掉，否则最外层的异常不知道时接口抛出的异常还是拦截器处理解析抛出的异常
				log.error("ApiReqLogAspect,解析返回结果异常", e);
			}
			return obj;
		} catch (Exception e) {
			log.error("ApiReqLogAspect Error , action:{}, 入参:{}", method, param);
			//异常直接抛出原始的异常，不要做任何包装处理,异常日志也不记录, 全局异常处理器CommonExceptionHandler会打印日志。
			throw e;
		}
	}


	/**
	 * 对controller接口进行连接请求日志时，不要对异常做处理，直接往外抛出，交给Controller层的全局异常处理器处理，
	 * 否则全局异常处理器拦截不到自动的业务异常。
	 * @author wangchao 
	 * @date 2020/10/15
	 * @param 
	 * @return void
	 */
	public void ApiReqLogAspectException(){
		String method="method";
		String param="param";
		try {
		} catch (VehicleException e) {
			log.error("ApiReqLogAspect1, action:{}, 入参:{}", method, param, e);
			throw e;
		} catch (Exception e) {
			log.error("ApiReqLogAspect2, action:{}, 入参:{}", method, param, e);
			throw new VehicleException(VehicleErrorEnum.SYSTEM_FAILED, e);
		} catch (Throwable e) {
			log.error("ApiReqLogAspect3, action:{}, 入参:{}", method, param, e);
			throw new VehicleException(VehicleErrorEnum.SYSTEM_FAILED, e);
		}
	}


	/**
	 * 请求入参解析
	 *
	 * @param args
	 * @return
	 */
	private String generateInputParam(Object[] args) {
		StringBuilder sb = new StringBuilder();
		for (Object arg : args) {
			sb.append(JsonUtil.toJson(arg));
			sb.append(";");
		}
		if(sb.length()<=0){
			return "{}";
		}
		String s = sb.toString();
		return s.substring(0,s.length()-1);
	}

}
