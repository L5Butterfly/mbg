package com.oxygen.mbgtools.mybatis.plugin;

import com.oxygen.mbgtools.utils.MyBatisUtils;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;


 /**
  * TkMyBatis3Impl
  * @author Administrator
  * @date 2020/10/28 11:47
  * @created by oxygen
  */
public class TkMyBatis3Impl extends IntrospectedTableMyBatis3Impl {

	@Override
	protected String calculateMyBatis3XmlMapperFileName() {
		StringBuilder sb = new StringBuilder();
		if (stringHasValue(tableConfiguration.getMapperName())) {
			String mapperName = tableConfiguration.getMapperName();
			int ind = mapperName.lastIndexOf('.');
			if (ind != -1) {
				mapperName = mapperName.substring(ind + 1);
			}
			//支持mapperName = "{0}Dao" 等用法
			//sb.append(fullyQualifiedTable.getDomainObjectName().substring(2,domainObjectName.length())+"Mapper");
			String domainObjectName = fullyQualifiedTable.getDomainObjectName();
			String underlineName = MyBatisUtils.HumpToUnderline(domainObjectName);
			sb.append(underlineName+"_mapper");
			// sb.append(MessageFormat.format(mapperName, fullyQualifiedTable.getDomainObjectName()));
			sb.append(".xml"); //$NON-NLS-1$
		} else {
			sb.append(fullyQualifiedTable.getDomainObjectName().substring(2,fullyQualifiedTable.getDomainObjectName().length()));
			sb.append("Mapper.xml"); //$NON-NLS-1$
		}
		return sb.toString();
	}
}

