package com.oxygen.mbgtools.base.annotation;


import java.lang.annotation.*;


/**
 * 日志注解
 * @author wangchao
 * @date 2020/9/17 14:37
 * @created by oxygen
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLogRegister {

   /**
	* controller层方法名称
	* @return
	*/
   String name();

}