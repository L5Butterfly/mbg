package com.oxygen.mbgtools.generate;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 代码生成工具
 * @author oxygen
 * @date 2020/5/7 18:13
 **/
@Slf4j
public class GenerateTool {


    /**
     * 代码生成工具
     * @param args
     */
    public static void main(String[] args) {
        try {
            generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * java程序方式执行代码生成，不适应jar包依赖mvn命令方式生成
     * @throws Exception
     */
    private static void generator() throws Exception {
        File configFile = new ClassPathResource("generatorConfig.xml").getFile();
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("代码生成完毕.....");
        log.info("代码生成完毕.....");
    }
}
