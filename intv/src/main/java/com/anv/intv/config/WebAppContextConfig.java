package com.anv.intv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.anv.intv.controller")
public class WebAppContextConfig implements WebMvcConfigurer {

    @Autowired
    ApplicationContext applicationContext;
    
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index");
	}

	/*
	 * @Bean public ViewResolver viewResolver() { InternalResourceViewResolver bean
	 * = new InternalResourceViewResolver();
	 * 
	 * bean.setViewClass(JstlView.class); bean.setPrefix("/WEB-INF/view/jsp/");
	 * bean.setSuffix(".jsp");
	 * 
	 * return bean; }
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	}

	// 1. Creating SpringResourceTemplateResolver
	@Bean
	public SpringResourceTemplateResolver springTemplateResolver() {
		SpringResourceTemplateResolver springTemplateResolver = new SpringResourceTemplateResolver();
		springTemplateResolver.setApplicationContext(this.applicationContext);
		springTemplateResolver.setPrefix("/WEB-INF/view/thymeleaf/");
		springTemplateResolver.setSuffix(".html");
		return springTemplateResolver;
	}

	// 2. Creating SpringTemplateEngine
	@Bean
	public SpringTemplateEngine springTemplateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(springTemplateResolver());
		return springTemplateEngine;
	}

	// 3. Registering ThymeleafViewResolver
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(springTemplateEngine());
		return viewResolver;
	}
}
