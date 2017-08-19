package com.emp.configuration;

/*
 *  DAO ad SVC  beans go into Root WebApplicationContext
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.emp.svc,com.emp.dao")
public class SpringRootConfig {

}
