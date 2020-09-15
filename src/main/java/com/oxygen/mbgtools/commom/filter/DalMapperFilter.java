package com.oxygen.mbgtools.commom.filter;


import com.oxygen.mbgtools.commom.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 过滤所有新增、修改数据库操作，在方法执行前设置时间和用户信息
 *
 * @author oxygen
 */
@Aspect
@Order(3)
@Component
public class DalMapperFilter {

    private static final Logger logger = LoggerFactory.getLogger(DalMapperFilter.class);
    /**
     * 待过滤的Mapper新增和更新方法名称
     */
    private static final List<String> UPDATE_METHOD = Arrays.asList("updateByExampleSelective", "updateByExample",
            "updateByPrimaryKeySelective", "updateByPrimaryKey");
    private static final List<String> INSERT_METHOD = Arrays.asList("insert", "insertSelective");
    private static final List<String> INSERT_BATCH_METHOD = Arrays.asList("insertBatch");
    private static final List<String> UPDATE_BATCH_METHOD = Arrays.asList("updateBatch");

    private static final String GET_METHOD_PREFIX = "get";
    private static final String SET_METHOD_PREFIX = "set";

    /**
     * 创建时间
     */
    private String gmtCreate = "setGmtCreate";
    /**
     * 创建人
     */
    private String createdBy = "setCreatedBy";
    private String createdBy2 = "setCreator";
    /**
     * 修改时间
     */
    private String gmtModified = "setGmtModified";
    /**
     * 修改人
     */
    private String modifiedBy = "setModifiedBy";
    private String modifiedBy2 = "setModifier";
    /**
     * 是否删除
     */
    private String isDeleted = "setIsDeleted";
    /**
     * 时间属性类型
     */
    private String dateType = "localDateTime";
    /**
     * 时间属性默认类型
     */
    private String DATE = "localDateTime";
    /**
     * 默认userId
     */
    private String defaultUserId = "0";

    /**
     * 通过反射设置更新和插入方法的创建人、创建时间、修改人、修改时间
     *
     * @param joinPoint
     */
    @Before("execution(* com.oxygen.mbgtools..*.dal.mapper..*.*(..))")
    public void InterceptCreateModifieMetoodSetProperty(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length <= 0 || args[0] == null) {
            return;
        }
        //User user = HsfContextUtil.getCurrentUser();
        User user=new User();
        if (!DATE.equals(dateType)) {
            this.reflectionSetMethod(methodName, args, user, new Date());
        } else {
            this.reflectionSetMethod(methodName, args, user, LocalDateTime.now());
        }
    }

    /**
     * 通过反射设置更新和插入方法的创建人、创建时间、修改人、修改时间
     * 修改失败不会抛出异常,会打印错误日志, TODO 邮件报警或异常处理平台
     *
     * @param methodName 方法名称(反射调用)
     * @param args       DO参数列表
     * @param user       用户信息
     * @param dateTime   当前时间
     */
    @SuppressWarnings("unchecked")
    public void reflectionSetMethod(String methodName, Object[] args, User user, Object dateTime) {
        if (UPDATE_METHOD.contains(methodName)) {
            updateMethodBaseFields(this.gmtModified, this.modifiedBy, this.modifiedBy2, this.isDeleted, args[0], user.getEmployeeId(), dateTime);
        } else if (UPDATE_BATCH_METHOD.contains(methodName)) {
            List<Object> list = (List<Object>) (args[0]);
            for (Object obj : list) {
                updateMethodBaseFields(this.gmtModified, this.modifiedBy, this.modifiedBy2, this.isDeleted, obj, user.getEmployeeId(), dateTime);
            }
        } else if (INSERT_METHOD.contains(methodName)) {
            updateMethodFields(this.gmtModified, this.modifiedBy, this.modifiedBy2, this.isDeleted, args[0], user.getEmployeeId(), dateTime);
            insertMethodSet(this.gmtCreate, this.createdBy, this.createdBy2, args[0], user.getEmployeeId(), dateTime);
        } else if (INSERT_BATCH_METHOD.contains(methodName)) {
            List<Object> list = (List<Object>) (args[0]);
            for (Object obj : list) {
                updateMethodFields(this.gmtModified, this.modifiedBy, this.modifiedBy2, this.isDeleted, obj, user.getEmployeeId(), dateTime);
                insertMethodSet(this.gmtCreate, this.createdBy, this.createdBy2, obj, user.getEmployeeId(), dateTime);
            }
        }
    }

    /**
     * 设置时间、修改人、删除标志位
     * 修历史的坑
     *
     * @param gmtModified
     * @param modifiedBy
     * @param modifiedBy2
     * @param isDeleted
     * @param arg
     * @param userId
     * @param dateTime
     */
    private static void updateMethodFields(String gmtModified, String modifiedBy, String modifiedBy2, String isDeleted, Object arg, String userId, Object dateTime) {
        updateMethodBaseFields(gmtModified, modifiedBy, modifiedBy2, isDeleted, arg, userId, dateTime);
        updateDeleteFlag(isDeleted, arg);
    }

    /**
     * 设置删除标志位
     * 修历史的坑
     *
     * @param isDeleted
     * @param arg
     */
    private static void updateDeleteFlag(String isDeleted, Object arg) {
        try {
            Object isDeletedValue = null;
            String isDeletedStr = isDeleted.substring(3);
            String getIsDeleted = GET_METHOD_PREFIX + isDeletedStr;
            Method getMethod = arg.getClass().getMethod(getIsDeleted);
            if (getMethod != null) {
                getMethod.setAccessible(true);
                isDeletedValue = getMethod.invoke(arg);
            }
            if (isDeletedValue == null) {
                Method method = arg.getClass().getMethod(isDeleted, Byte.class);
                if (method != null) {
                    method.setAccessible(true);
                    method.invoke(arg, (byte) 0);
                }
            }
        } catch (NoSuchMethodException e) {
            //不打印日志
        } catch (Exception e) {
            //logger.error("反射Mapper的设置{}属性方法调用失败,DO参数为={}", isDeleted, arg.getClass().getName(), e);
        }
    }

    /**
     * 设置修改时间、修改人、有异常则忽略
     *
     * @param gmtModified 修改时间字段
     * @param modifiedBy  修改人字段
     * @param arg         待修改DO对象
     * @param userId      当前用户ID
     * @param dateTime    当前时间
     */
    private static void updateMethodBaseFields(String gmtModified, String modifiedBy, String modifiedBy2, String isDeleted, Object arg, String userId, Object dateTime) {
        try {
            Method method = null;
            arg.getClass().getSuperclass();
            if (dateTime instanceof LocalDateTime) {
                method = arg.getClass().getMethod(gmtModified, LocalDateTime.class);
            } else {
                method = arg.getClass().getMethod(gmtModified, Date.class);
            }
            if (method != null) {
                method.setAccessible(true);
                method.invoke(arg, dateTime);
            }
        } catch (NoSuchMethodException ne) {
        } catch (Exception e) {
        }
        setOperator(arg,modifiedBy,userId);

        setOperator(arg,modifiedBy2,userId);
    }

    /**
     * 设置创建时间、创建人、有异常则忽略
     *
     * @param gmtCreate 创建时间字段
     * @param createBy  创建人字段
     * @param arg       待修改DO对象
     * @param userId    当前用户ID
     * @param dateTime  当前时间
     */
    private static void insertMethodSet(String gmtCreate, String createBy, String createBy2, Object arg, String userId, Object dateTime) {
        try {
            Method method = null;
            if (dateTime instanceof LocalDateTime) {
                method = arg.getClass().getMethod(gmtCreate, LocalDateTime.class);
            } else {
                method = arg.getClass().getMethod(gmtCreate, Date.class);
            }
            if (method != null) {
                method.setAccessible(true);
                method.invoke(arg, dateTime);
            }
        } catch (NoSuchMethodException ne) {
        } catch (Exception e) {
        }

        setOperator(arg,createBy,userId);
        setOperator(arg,createBy2,userId);
    }

    /**
     * 设置修改人or提交人
     *
     * @param arg        原数据
     * @param methodName 方法名
     * @param userId     HSF上下文中取到的用户ID
     */
    private static void setOperator(Object arg, String methodName, String userId) {
        try {
            Object value = null;
            String methodNameStr = methodName.substring(3);
            String readMethodStr = GET_METHOD_PREFIX + methodNameStr;
            String writeMethodStr = SET_METHOD_PREFIX + methodNameStr;
            //get方法
            Method readMethod = arg.getClass().getMethod(readMethodStr);
            //set方法
            Method writeMethod = arg.getClass().getMethod(writeMethodStr, String.class);
            //获取get值
            if (readMethod != null) {
                readMethod.setAccessible(true);
                value = readMethod.invoke(arg);
            }
            if (writeMethod != null) {
                writeMethod.setAccessible(true);
                if (value == null) {
                    writeMethod.invoke(arg, userId);
                }
            }
        } catch (NoSuchMethodException e) {
            //不打印日志
        } catch (Exception e) {
            //logger.error("反射Mapper的设置{}属性方法调用失败,DO参数为={}", isDeleted, arg.getClass().getName(), e);
        }
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }
}
