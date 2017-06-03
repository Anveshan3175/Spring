package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.beans")
public class AppConfiguration {

	public AppConfiguration() {
		// TODO Auto-generated constructor stub
	}

}
