package com.rs.client.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rs.client.configuration.SpringRestConfiguration;
import com.rs.client.configuration.SpringRootConfig;
import com.rs.client.configuration.SpringWebConfiguration;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringRootConfig.class,SpringRestConfiguration.class };
		//return null;
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return new Class[] { SpringWebConfiguration.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}