package com.oxygen.mbgtools.mybatis.bean;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 通用的数据库实体操作接口
 * 
 * @date 2020/7/9
 *
 * @param <T>  数据对象
 * @param <E>  查询条件
 */
public interface BaseMapper<T,E> {

    /**
     * 数据汇总，通过example条件查询数据
     * @param example
     * @return
     */
    int countByExample(E example);

    /**
     * 通过example条件删除数据
     * @param example
     * @return
     */
    int deleteByExample(E example);


    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增数据，null的字段为空字符串
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 根据插入对象字段插入数据
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据条件查询数据
     * @param example
     * @return
     */
    List<T> selectByExample(E example);

    /**
     * 主键获取数据
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);


    /**
     * 根据条件更新数据,选择字段更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param(value = "record") T record, @Param(value = "example") E example);

    /**
     * 根据条件更新数据
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param(value = "record") T record, @Param(value = "example") E example);

    /**
     * 主键选择字段更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 主键更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);


    /**
     * 批量插入数据
     * @param records
     * @return
     */
    int insertBatch(List<T> records);


    /**
     * 批量更新数据
     * @param records
     * @return
     */
    int updateBatch(List<T> records);
}
