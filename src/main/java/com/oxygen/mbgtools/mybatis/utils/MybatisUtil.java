package com.oxygen.mbgtools.mybatis.utils;


import com.oxygen.mbgtools.mybatis.bean.Pair;
import com.oxygen.mbgtools.mybatis.bean.SqlPair;
import com.oxygen.mbgtools.mybatis.bean.UpSetPair;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Mybatis Example JSON字符串查询分装
 * @author oxygen
 * @date 2020/7/9
 **/
public class MybatisUtil {

    /**
     * 向MybatisGenerator生成的criteria中追加JSON条件
     *
     * @param criteria  criteria对象
     * @param field     JSON字段名
     * @param jPath     jPath
     * @param condition 条件=，>，>=，<，<=等
     * @param value     值
     * @param <T>
     * @return criteria对象
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <T> T addJsonCriterion(T criteria, String field, String jPath, String condition, String value)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = criteria.getClass().getSuperclass().getDeclaredMethod("addCriterion", String.class,
            Object.class, String.class);
        method.setAccessible(true);
        method.invoke(criteria, "JSON_UNQUOTE(JSON_EXTRACT(" + field + ", '" + jPath + "'))" + condition,
            value,
            field + "->>'" + jPath + "'");
        return criteria;
    }

    /**
     * @param criteria
     * @param pairs
     * @param <T>
     * @return
     */
    public static <T> T addJsonCriterion(T criteria, List<SqlPair> pairs) {
        if (CollectionUtils.isNotEmpty(pairs)) {
            for (SqlPair sqlPair : pairs) {
                addJsonCriterion(criteria, sqlPair);
            }
        }
        return criteria;
    }

    /**
     * @param criteria
     * @param pair
     * @param <T>
     * @return
     */
    public static <T> T addJsonCriterion(T criteria, SqlPair pair) {
        if (pair == null || criteria == null) {
            return criteria;
        }
        try {
            Method method = criteria.getClass().getSuperclass().getDeclaredMethod("addCriterion", String.class,
                    Object.class, String.class);
            method.setAccessible(true);
            StringBuilder sb = new StringBuilder("JSON_UNQUOTE(JSON_EXTRACT(");
            sb.append(pair.getField());
            sb.append(", '$.");
            sb.append(pair.getKey());
            sb.append("')) ");
            sb.append(pair.getJsonSqlConditionEnum().getCondition());
            sb.append(" ");
            method.invoke(criteria, sb.toString(), pair.getValue(),
                    pair.getField() + "->>'" + pair.getKey() + "'");
            return criteria;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 新增或者修改json中的字段 只支持json中是字符串类型
     * @param pair
     * @return
     */
    public static String upsertJson(UpSetPair pair) {
        if (pair == null || CollectionUtils.isEmpty(pair.getAttributes())) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder("JSON_SET(");
            sb.append(pair.getField());
            for (Pair item : pair.getAttributes()) {
                sb.append(", '$.");
                sb.append(item.getKey());
                sb.append("', '");
                sb.append(item.getValue());
                sb.append("' ");
            }
            sb.append(")");
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
