package com.oxygen.mbgtools.mybatis.bean;

import lombok.Data;
import java.util.List;


/**
 * 扩展字段属性
 * @author oxygen
 * @date 2020/7/9
 **/
@Data
public class UpSetPair {

    /**
     * 字段名，feature
     */
    private String field;

    /**
     * JSON对象的字段属性，key-value
     */
    private List<Pair> attributes;
}
