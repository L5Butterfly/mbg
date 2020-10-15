package com.oxygen.mbgtools;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 忽略SpringBoot自动装配的配置，排查数据源的自动装配
 * @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
 * @author oxygen
 * @date 2020/7/3
 **/
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = {"com.oxygen.mbgtools.mapper"})
@EnableTransactionManagement
public class MbgToolsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(MbgToolsApplication.class, args);
		String[] beanDefinitionNames = app.getBeanDefinitionNames();
		log.info("一共扫描到{}个Bean实例",beanDefinitionNames.length);
		for (int i = 0; i < beanDefinitionNames.length; i++) {
			//System.out.println( beanDefinitionNames[i]);
		}
	}
}
