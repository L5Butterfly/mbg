package com.oxygen.mbgtools.mybatis.plugin;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MybatisResolver extends JavaTypeResolverDefaultImpl{
    public MybatisResolver() {
        super();
        typeMap.put(Types.DATE, new JdbcTypeInformation("DATE", 
                new FullyQualifiedJavaType(LocalDate.class.getName())));
        typeMap.put(Types.TIME, new JdbcTypeInformation("TIME", 
                new FullyQualifiedJavaType(LocalTime.class.getName())));
        typeMap.put(Types.TIMESTAMP, new JdbcTypeInformation("TIMESTAMP", 
                new FullyQualifiedJavaType(LocalDateTime.class.getName())));
    }
}
