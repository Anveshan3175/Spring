package com.anv.intv.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.anv.intv.svc,com.anv.intv.dao")
public class RootAppContextConfig {

}
