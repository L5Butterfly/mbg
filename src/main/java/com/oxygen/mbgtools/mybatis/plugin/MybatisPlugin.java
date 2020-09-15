package com.oxygen.mbgtools.mybatis.plugin;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * MybatisPlugin 生成SQL对应的XML数据库操作
 * @author oxygen
 *
 */
public class MybatisPlugin extends PluginAdapter{

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	private static String FULLY_QUALIFIED_PAGE = "com.oxygen.mbgtools.mybatis.bean.Page";
	private static String SEPARATOR_DOT = ".";
    private static String ANNOTATION_RESOURCE_PACKAGE = "javax.annotation.Resource";
    private static String SUPER_INTERFACE = "com.oxygen.mbgtools.mybatis.bean.BaseMapper";
    private static String BASE_CLASS = "com.oxygen.mbgtools.mybatis.bean.BaseBean";
    private static String ANNOTATION_RESOURCE = "@Resource";

//	@Override
//	public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
//									   IntrospectedTable introspectedTable, ModelClassType modelClassType) {
//		return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
//	}

    /**
     * Mapper类继承统一泛型基础BaseMapper
     * 增加Resource注解
     */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType baseInterfaze = new FullyQualifiedJavaType(SUPER_INTERFACE);
        interfaze.addSuperInterface(baseInterfaze);
        FullyQualifiedJavaType annotation = new FullyQualifiedJavaType(ANNOTATION_RESOURCE_PACKAGE);
        interfaze.addAnnotation(ANNOTATION_RESOURCE);
        interfaze.addImportedType(annotation);
        interfaze.addImportedType(baseInterfaze);
        FullyQualifiedJavaType modelType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        baseInterfaze.addTypeArgument(modelType);
        baseInterfaze.addTypeArgument(exampleType);
        
        GeneratedJavaFile javaFile = new GeneratedJavaFile(interfaze, this.context.getJavaModelGeneratorConfiguration().getTargetProject(), this.context.getProperty("javaFileEncoding"), this.context.getJavaFormatter());
        boolean exist =  this.fileExist(javaFile.getTargetProject(), javaFile.getTargetPackage(), javaFile.getFileName());
        if (exist) {
        	return false;
        }
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}
	/**
	 * 实体类继承统一父类
	 */
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType superClass = new FullyQualifiedJavaType(BASE_CLASS);
		topLevelClass.setSuperClass(superClass);
		topLevelClass.addImportedType(superClass);
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}
	/**
	 * 增加page
	 */
    @Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.addPage(topLevelClass, introspectedTable, "page");
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}
    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        FullyQualifiedJavaType page = new FullyQualifiedJavaType(FULLY_QUALIFIED_PAGE);
        topLevelClass.addImportedType(page);
        CommentGenerator commentGenerator = this.context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(page);
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(page, name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(page);
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }
    
	@Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
//		introspectedTable.setMyBatis3XmlMapperFileName(introspectedTable.getMyBatis3XmlMapperFileName().replace("DO", ""));
        XmlElement parentElement = document.getRootElement();
        this.addPageSql(parentElement, introspectedTable);
        this.addBatchInsertXml(parentElement, introspectedTable);
        this.addBatchUpdateXml(parentElement, introspectedTable);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement pageStart = new XmlElement("include");
        pageStart.addAttribute(new Attribute("refid", "MysqlDialectPrefix"));
        element.getElements().add(7, pageStart);
        XmlElement isNotNullElement = new XmlElement("include");
        isNotNullElement.addAttribute(new Attribute("refid", "MysqlDialectSuffix"));
        element.getElements().add(isNotNullElement);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }
    private void addPageSql(XmlElement element, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        XmlElement paginationPrefixElement = new XmlElement("sql");
        this.context.getCommentGenerator().addComment(paginationPrefixElement);
        paginationPrefixElement.addAttribute(new Attribute("id", "MysqlDialectPrefix"));
        XmlElement pageStart = new XmlElement("if");
        pageStart.addAttribute(new Attribute("test", "page != null"));
        pageStart.addElement(new TextElement("from " + tableName + " , ( select id as temp_page_table_id "));
        paginationPrefixElement.addElement(pageStart);
        element.addElement(paginationPrefixElement);
        XmlElement orderByClause = new XmlElement("if");
        orderByClause.addAttribute(new Attribute("test", "orderByClause != null"));
        orderByClause.addElement(new TextElement("order by ${orderByClause}"));
        XmlElement paginationSuffixElement = new XmlElement("sql");
        this.context.getCommentGenerator().addComment(paginationSuffixElement);
        paginationSuffixElement.addAttribute(new Attribute("id", "MysqlDialectSuffix"));
        XmlElement pageEnd = new XmlElement("if");
        pageEnd.addAttribute(new Attribute("test", "page != null"));
        pageEnd.addElement(new TextElement("<![CDATA[ limit #{page.offset}, #{page.limit} ) as temp_page_table ]]> where " + tableName + ".id=temp_page_table.temp_page_table_id"));
        pageEnd.addElement(orderByClause);
        paginationSuffixElement.addElement(pageEnd);
        element.addElement(paginationSuffixElement);
    }
	   public void addBatchInsertXml(XmlElement element, IntrospectedTable introspectedTable) {
	        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
	        String incrementField = introspectedTable.getTableConfiguration().getGeneratedKey().getColumn();
	        if(incrementField != null) {
	            incrementField = incrementField.toUpperCase();
	        }

	        StringBuilder dbcolumnsName = new StringBuilder();
	        StringBuilder javaPropertyAndDbType = new StringBuilder();
	        Iterator<IntrospectedColumn> tableName = columns.iterator();

	        while(tableName.hasNext()) {
	            IntrospectedColumn insertBatchElement = (IntrospectedColumn)tableName.next();
	            String trim1Element = insertBatchElement.getActualColumnName();
	            if(!trim1Element.toUpperCase().equals(incrementField)) {
	                dbcolumnsName.append("`" + trim1Element + "`,");
	                javaPropertyAndDbType.append("#{item." + insertBatchElement.getJavaProperty() + ",jdbcType=" + insertBatchElement.getJdbcTypeName());
	                if (StringUtils.isNotBlank(insertBatchElement.getTypeHandler())) {
						javaPropertyAndDbType.append(", typeHandler=" + insertBatchElement.getTypeHandler());
					}
					javaPropertyAndDbType.append("},");
	            }
	        }

	        String tableName1 = introspectedTable.getTableConfiguration().getTableName();
	        XmlElement insertBatchElement1 = new XmlElement("insert");
	        this.context.getCommentGenerator().addComment(insertBatchElement1);
	        insertBatchElement1.addAttribute(new Attribute("id", "insertBatch"));
	        insertBatchElement1.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
	        insertBatchElement1.addAttribute(new Attribute("keyProperty", "id"));
	        insertBatchElement1.addAttribute(new Attribute("useGeneratedKeys", "true"));
	        insertBatchElement1.addElement(new TextElement("insert into " + tableName1));
	        XmlElement trim1Element1 = new XmlElement("trim");
	        trim1Element1.addAttribute(new Attribute("prefix", "("));
	        trim1Element1.addAttribute(new Attribute("suffix", ")"));
	        trim1Element1.addAttribute(new Attribute("suffixOverrides", ","));
	        trim1Element1.addElement(new TextElement(dbcolumnsName.toString()));
	        insertBatchElement1.addElement(trim1Element1);
	        insertBatchElement1.addElement(new TextElement("values"));
	        XmlElement foreachElement = new XmlElement("foreach");
	        foreachElement.addAttribute(new Attribute("collection", "list"));
	        foreachElement.addAttribute(new Attribute("index", "index"));
	        foreachElement.addAttribute(new Attribute("item", "item"));
	        foreachElement.addAttribute(new Attribute("separator", ","));
	        foreachElement.addElement(new TextElement("("));
	        XmlElement trim2Element = new XmlElement("trim");
	        trim2Element.addAttribute(new Attribute("suffixOverrides", ","));
	        trim2Element.addElement(new TextElement(javaPropertyAndDbType.toString()));
	        foreachElement.addElement(trim2Element);
	        foreachElement.addElement(new TextElement(")"));
	        insertBatchElement1.addElement(foreachElement);
	        element.addElement(insertBatchElement1);
	    }
	   public void addBatchUpdateXml(XmlElement element, IntrospectedTable introspectedTable) {
	        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
	        String incrementField = introspectedTable.getTableConfiguration().getGeneratedKey().getColumn();
	        XmlElement insertBatchElement = new XmlElement("update");
	        this.context.getCommentGenerator().addComment(insertBatchElement);
	        insertBatchElement.addAttribute(new Attribute("id", "updateBatch"));
	        insertBatchElement.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
	        XmlElement foreachElement = new XmlElement("foreach");
	        foreachElement.addAttribute(new Attribute("collection", "list"));
	        foreachElement.addAttribute(new Attribute("index", "index"));
	        foreachElement.addAttribute(new Attribute("item", "item"));
	        foreachElement.addAttribute(new Attribute("separator", ";"));
	        foreachElement.addElement(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
	        XmlElement setElement = new XmlElement("set");
	        Iterator<IntrospectedColumn> var8 = columns.iterator();

	        while(true) {
	            IntrospectedColumn introspectedColumn;
	            String columnName;
	            do {
	                if(!var8.hasNext()) {
	                    foreachElement.addElement(setElement);
	                    foreachElement.addElement(new TextElement("where " + incrementField + " = #{item." + incrementField + "}"));
	                    insertBatchElement.addElement(foreachElement);
	                    element.addElement(insertBatchElement);
	                    return;
	                }

	                introspectedColumn = (IntrospectedColumn)var8.next();
	                columnName = introspectedColumn.getActualColumnName();
	            } while(incrementField != null && incrementField.toUpperCase().equals(columnName.toUpperCase()));
	            XmlElement ifElement = new XmlElement("if");
	            Attribute attribute = new Attribute("test", "item." + introspectedColumn.getJavaProperty() + " != null");
	            ifElement.addAttribute(attribute);
	            StringBuilder ifElementContentSb = new StringBuilder(columnName + " = #{item." + introspectedColumn.getJavaProperty() + ",jdbcType=" + introspectedColumn.getJdbcTypeName());
				if (StringUtils.isNotBlank(introspectedColumn.getTypeHandler())) {
					ifElementContentSb.append(", typeHandler=" + introspectedColumn.getTypeHandler());
				}
				ifElementContentSb.append("},");
				ifElement.addElement(new TextElement(ifElementContentSb.toString()));
//	            setElement.addElement(new TextElement("`" + columnName + "` = #{item." + introspectedColumn.getJavaProperty() + ",jdbcType=" + introspectedColumn.getJdbcTypeName() + "},"));
	            setElement.addElement(ifElement);
	        }
	    }
    
    @Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		return super.sqlMapGenerated(sqlMap, introspectedTable);
	}
	/**
     * 增加自定义扩展xml文件
     */
    @Override
    public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable) {
        String fileNameExt = introspectedTable.getMyBatis3XmlMapperFileName().replace(".xml", "Ext.xml");
		if (this.fileExist(this.context.getSqlMapGeneratorConfiguration().getTargetProject(), introspectedTable.getMyBatis3XmlMapperPackage(), fileNameExt)) {
            return super.contextGenerateAdditionalXmlFiles(introspectedTable);
        } else {
            Document document = new Document("-//mybatis.org//DTD Mapper 3.0//EN", "http://mybatis.org/dtd/mybatis-3-mapper.dtd");
            XmlElement root = new XmlElement("mapper");
            document.setRootElement(root);
            String namespace = introspectedTable.getMyBatis3SqlMapNamespace();
            root.addAttribute(new Attribute("namespace", namespace));
            GeneratedXmlFile gxf = new GeneratedXmlFile(document, fileNameExt, introspectedTable.getMyBatis3XmlMapperPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), false, this.context.getXmlFormatter());
            return Arrays.asList(gxf);
        }
    }
	/**
	 * 判断目标文件是否存在
	 * @param targetProject 源码目录
	 * @param targetPackage 包路径
	 * @param fileName 文件名称
	 * @return 存在为true、不存在为false
	 */
    private boolean fileExist(String targetProject, String targetPackage, String fileName) {
        File path = new File(targetProject);
        File directory = new File(path, targetPackage.replace(SEPARATOR_DOT, File.separator));
        if(!directory.isDirectory()) {
            if(!directory.mkdirs()) {
                return true;
            }
        }
        return new File(directory, fileName).exists();
    }
    
	/**
	 * 基本的DAO方法均不生成，继承父类方法。
	 */
	@Override
	public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientInsertMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	@Override
	public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
}
