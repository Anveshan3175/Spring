package com.rs.configuration;

/*
 *  DAO ad SVC  beans go into Root WebApplicationContext
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.rs.svc,com.rs.dao")
public class SpringRootConfig {

}
