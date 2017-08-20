package com.emp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.emp.controller")
@PropertySource(value = { "classpath:application.properties" })
public class SpringWebConfiguration extends WebMvcConfigurerAdapter{

	 @Bean
	 public InternalResourceViewResolver jspViewResolver() {
		 	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();	      
		 	viewResolver.setPrefix("/WEB-INF/view/");
		 	viewResolver.setSuffix(".jsp");
	        return viewResolver;
	        
	 }
}
