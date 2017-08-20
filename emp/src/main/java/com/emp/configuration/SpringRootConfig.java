package com.emp.configuration;

/*
 *  DAO ad SVC  beans go into Root WebApplicationContext
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.emp.svc,com.emp.dao")
public class SpringRootConfig {

}
