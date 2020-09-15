package com.oxygen.mbgtools.mybatis.bean;

import com.oxygen.mbgtools.mybatis.enumate.JsonConditionEnum;
import lombok.Data;
import org.springframework.util.Assert;

/**
 * 扩展字段的属性描述
 * @author oxygen
 * @date 2020/7/9
 **/
@Data
public class SqlPair {

    /**
     * 字段名，feature
     */
    private String field;

    /**
     * Json字段的key
     */
    private String key;

    /**
     * Json字段的value
     */
    private Object value;

    /**
     * JSON查询条件枚举
     */
    private JsonConditionEnum jsonSqlConditionEnum;

    /**
     * 构造
     * @param key
     * @param value
     */
    public SqlPair(String field, String key, Object value, JsonConditionEnum jsonSqlConditionEnum) {
        Assert.notNull(field, "filed can't be null");
        Assert.notNull(key, "key can't be null");
        Assert.notNull(value, "value can't be null");
        Assert.notNull(jsonSqlConditionEnum, "jsonSqlConditionEnum can't be null");
        this.field = field;
        this.key = key;
        this.value = value;
        this.jsonSqlConditionEnum = jsonSqlConditionEnum;
    }
}
