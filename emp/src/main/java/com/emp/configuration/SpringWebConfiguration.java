package com.emp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
	 
	 @Autowired
	 private Environment env;
	    
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }
}
