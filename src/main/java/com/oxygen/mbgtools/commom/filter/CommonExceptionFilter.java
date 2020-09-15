package com.oxygen.mbgtools.commom.filter;

import com.oxygen.mbgtools.commom.CommonCodeEnum;
import com.oxygen.mbgtools.commom.CommonException;
import com.oxygen.mbgtools.commom.DataResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 所有服务接口的异常拦截器
 *
 * @author oxygen
 */
@Aspect
@Order(1)
@Component
public class CommonExceptionFilter {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionFilter.class);

    @Around("execution(* com.oxygen.mbgtools.*.server..*.impl..* (..))")
    public Object filterException(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (CommonException e) {
            logger.error("code={},common_msg={}", e.getCode(), e.getMsg(), e);
            DataResult<String> dataResult = new DataResult<>();
            dataResult.setCode(e.getCode());
            dataResult.setMsg(e.getMsg());
            dataResult.setTraceId(UUID.randomUUID().toString());
            return dataResult;
        } catch (Throwable e) {
            logger.error("code={},exception_msg={}", CommonCodeEnum.FAIL.getCode(), e.getMessage(), e);
            DataResult<String> dataResult = new DataResult<>();
            dataResult.setCode(CommonCodeEnum.FAIL.getCode());
            String service = "serviceName";
            dataResult.setMsg(CommonCodeEnum.FAIL.getMsg() + "|" + e.getMessage() + "|" + service);
            dataResult.setTraceId(UUID.randomUUID().toString());
            return dataResult;
        }
    }
}
