
### 参考方案

MyBatis Generator尝试与踩坑
https://www.jianshu.com/p/becfff733516

mybatis插件--(1)--mybatis generator自定义插件或者扩展报Cannot instantiate object of type XXX
https://blog.csdn.net/u_ascend/article/details/80742919




### 代码生成遇到的问题

[ERROR] Failed to execute goal org.mybatis.generator:mybatis-generator-maven-plugin:1.3.2:generate (default-cli) 
on project mbg-tools: Execution default-cli of goal org.mybatis.generator:mybatis-generator-maven-plugin:1.3.2:generate
 failed: Cannot instantiate object of type com.oxygen.mbgtools.mybatis.plugin.MybatisResolver -> [Help 1]



failed: Cannot instantiate object of type com.oxygen.mbgtools.mybatis.plugin.MybatisResolver



### jar生成依赖的运行命令

mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate




