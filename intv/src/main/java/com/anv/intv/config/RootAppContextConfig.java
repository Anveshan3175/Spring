package com.anv.intv.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.anv.intv.svc,com.anv.intv.dao")
public class RootAppContextConfig {

	/*
	 * @Bean public MessageSource messageSource() {
	 * ReloadableResourceBundleMessageSource messageSource = new
	 * ReloadableResourceBundleMessageSource();
	 * 
	 * messageSource.setBasename("classpath:messages");
	 * messageSource.setDefaultEncoding("UTF-8"); return messageSource; }
	 */
}
