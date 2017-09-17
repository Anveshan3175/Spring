package com.rs.client.configuration;

/*
 *  DAO ad SVC  beans go into Root WebApplicationContext
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.rs.client.svc")
public class SpringRootConfig {

}
