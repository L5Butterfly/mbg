package com.oxygen.mbgtools.commom.annotation;

import java.lang.annotation.*;

/**
 * 自定义的属性校验器，标注在方法上，则该方法的执行时会由参数校验器拦截并进行属性的校验
 * @author yugao
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AttributeValidate {
}