package com.oxygen.mbgtools.commom.filter;


import com.oxygen.mbgtools.commom.CommonCodeEnum;
import com.oxygen.mbgtools.commom.CommonException;
import com.oxygen.mbgtools.commom.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 验证对象的属性过滤器
 * @author oxygen
 * @date 2020/7/6
 **/
@Aspect
@Order(2)
@Component
public class AttributeValidateFilter {

    /**
     * 应用单例校验器-由工厂获取
     */
    private static final Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before("@annotation(com.oxygen.mbgtools.commom.annotation.AttributeValidate))")
    public void before(JoinPoint point) throws NoSuchMethodException, SecurityException {
        Object target = point.getThis();
        Object[] args = point.getArgs();
        Method method = ((MethodSignature)point.getSignature()).getMethod();
        Set<ConstraintViolation<Object>> violationSet = validateAttribute(target, method, args);
        checkConstraintViolation(violationSet);
    }

    /**
     * 检查违反约束对象Set,并将校验信息封装为异常抛出
     *
     * @param violationSet 违反约束对象Set
     * @throws CommonException (violationSet不为空则抛出异常)
     */
    private void checkConstraintViolation(Set<ConstraintViolation<Object>> violationSet) {
        if (!violationSet.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Object> violation : violationSet) {
                sb.append("[");
                sb.append(violation.getMessage());
                sb.append("]");
            }
            throw new CommonException(CommonCodeEnum.PARAM_ERROR.getCode(), sb.toString());
        }
    }

    /**
     * 校验所有参数对象的属性
     * 1.处理所有参数对象,如果参数为空则执行检查方法参数对象
     * 2.如果参数是list，则判断List是否有元素，无元素执行检查方法参数对象，有元素则循环获取每一个对象再校验其属性值
     * 3.其他对象将参数转换为对应的对象后校验对象的属性
     *
     * @param target 调用目标对象
     * @param method 调用方法
     * @param args   参数对象列表
     * @return 违反约束对象Set
     */
    @SuppressWarnings("unchecked")
    private Set<ConstraintViolation<Object>> validateAttribute(Object target, Method method, Object[] args) {
        Set<ConstraintViolation<Object>> set = new HashSet<ConstraintViolation<Object>>();
        for (Object arg : args) {
            if (arg == null) {
                set.addAll(validatorMethodParam(target, method, args));
            } else if (arg instanceof List) {
                if (CollectionUtils.isEmpty((List<Object>)arg)) {
                    set.addAll(validatorMethodParam(target, method, args));
                } else {
                    for (Object obj : (List<Object>)arg) {
                        set.addAll(validatorObject2Instance(obj));
                    }
                }
            } else {
                set.addAll(validatorObject2Instance(arg));
            }
        }
        return set;
    }

    /**
     * 检查方法参数对象，如果参数上有校验注解则检查
     *
     * @param target 调用目标对象
     * @param method 调用方法
     * @param args   参数对象列表
     * @return 违反约束对象Set
     */
    private Set<ConstraintViolation<Object>> validatorMethodParam(Object target, Method method, Object[] args) {
        ExecutableValidator validatorParam = validator.forExecutables();
        Set<ConstraintViolation<Object>> violationSet = validatorParam.validateParameters(target, method, args);
        return violationSet;
    }

    /**
     * 将参数转换为对应的对象后校验对象的属性
     * 1.Page对象特殊处理
     * 2.其他POJO对象按照validation bean注解方式校验
     *
     * @param arg 参数对象
     * @return 违反约束对象Set
     * @throws CommonException (分页limit或offset字段为空或小于0则抛出异常)
     */
    private Set<ConstraintViolation<Object>> validatorObject2Instance(Object arg) {
        if (arg instanceof Page) {
            Page page = (Page)arg;
            if (page.getLimit() == null || page.getLimit() < 0) {
                throw new CommonException(CommonCodeEnum.PARAM_ERROR.getCode(), "分页limit不可以为空或小于0");
            }
            if (page.getOffset() == null || page.getOffset() < 0) {
                throw new CommonException(CommonCodeEnum.PARAM_ERROR.getCode(), "分页offset不可以为空或小于0");
            }
        }
        return validator.validate(arg);
    }
}
