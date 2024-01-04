package org.example.my_jira_boot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.example.my_jira_boot.mapper")
public class MybatisPlusConfig {

}
