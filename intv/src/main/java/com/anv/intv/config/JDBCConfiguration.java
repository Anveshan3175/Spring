package com.anv.intv.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties" })
@EnableTransactionManagement
public class JDBCConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		dataSource.setInitialSize(Integer.parseInt(env.getRequiredProperty("jdbc.pool.initsize")));
		dataSource.setMaxTotal(Integer.parseInt(env.getRequiredProperty("jdbc.pool.maxsize")));
		return dataSource;
	}

	   @Bean
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(dataSource());
	      sessionFactory.setPackagesToScan(
	        new String[] { "com.anv.intv.entities" });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	 
	      return sessionFactory;
	   }
	   
	   Properties hibernateProperties() {
		      return new Properties() {
		         {			
				 setProperty("hibernate.hbm2ddl.auto",
						 env.getProperty("hibernate.hbm2ddl.auto"));				
		         setProperty("hibernate.dialect",
		        		 env.getProperty("hibernate.dialect"));	         	
		         setProperty("hibernate.show_sql",
				         env.getProperty("hibernate.show_sql"));
		         setProperty("hibernate.generate_statistics",
				         env.getProperty("hibernate.generate_statistics"));
		         setProperty("hibernate.use_sql_comments",
				         env.getProperty("hibernate.use_sql_comments"));
		         }
		      };
		   }
	   
		@Bean
		public HibernateTransactionManager hibernateTransactionManager(){
		     return new HibernateTransactionManager(sessionFactory().getObject());
		}
}
