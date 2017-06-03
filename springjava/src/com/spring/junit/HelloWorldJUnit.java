package com.spring.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.beans.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:services.xml", "classpath:daos.xml"})
public class HelloWorldJUnit {

	@Autowired
	private Student std;
	

	@Test
	public void testSampleStudent() {
		
		assertTrue(std.getName().equals("Anveshan"));
	}
}
