package com.oxygen.mbgtools.mybatis.enumate;


/**
 * 
 * @author oxygen
 * @date 2020/7/9
 **/
public enum  JsonConditionEnum {

    /**
     * 大于
     */
    GREATER_THAN(">"),
    /**
     * 小于
     */
    LESS_THAN("<"),
    /**
     * 等于
     */
    EQUALS("="),
    /**
     * 大于等于
     */
    GREATER_EQUALS(">="),
    /**
     * 小于等于与
     */
    LESS_EQUALS("<="),
    /**
     * like
     */
    LIKE("like"),
    ;

    private String condition;

    /**
     *
     * @param condition
     */
    private JsonConditionEnum(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }
}
