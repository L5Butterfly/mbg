package com.oxygen.mbgtools.mybatis.component;

import org.apache.commons.collections4.MapUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.codehaus.jackson.map.ObjectMapper;
import java.sql.*;
import java.util.Map;


/**
 * MYSQL-JSON类型数据处理
 * @author oxygen
 * @description 自定义Mybatis数据类型解析器
 * @date 2020/6/11 17:16
 **/
public class JsonMapTypeHandler extends BaseTypeHandler<Map<String, Object>> {

    /**
     * Mybatis 表数据生成，指定字段生成的处理器类型
     * <table domainObjectName="InventoryAllocateRelationDO" tableName="inventory_allocate_relation">
     *             <generatedKey column="id" sqlStatement="JDBC"/>
     *             <columnOverride column="feature" javaType="java.util.Map"
     *             typeHandler="com.xxx.dal.handler.JsonMapTypeHandler"/>
     * </table>
     */
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Map<String, Object> getNullableResult(ResultSet rs, String columnName) {
        try {
            String value = rs.getString(columnName);
            return mapper.readValue(value, Map.class);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Map<String, Object> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            String value = rs.getString(columnIndex);
            return mapper.readValue(value, Map.class);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Map<String, Object> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            String value = cs.getString(columnIndex);
            return mapper.readValue(value, Map.class);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, Object> parameter, JdbcType jdbcType)
            throws SQLException {
        if (MapUtils.isEmpty(parameter)) {
            ps.setNull(i, Types.VARCHAR);
        } else {
            try {
                ps.setString(i, JsonUtil.toJson(parameter));
            } catch (Exception e) {
                throw new SQLException(e.getMessage());
            }
        }
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        JsonMapTypeHandler handler=new JsonMapTypeHandler();
        handler.getNullableResult(null,null);
    }
}
