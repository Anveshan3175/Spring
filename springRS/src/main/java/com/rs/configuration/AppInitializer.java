package com.rs.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rs.configuration.SpringJDBCConfiguration;
import com.rs.configuration.SpringRootConfig;
import com.rs.configuration.SpringWebConfiguration;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringRootConfig.class,SpringJDBCConfiguration.class };
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