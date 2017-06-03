package com.spring.helloworld;

public class TestAutowired {

	public TestAutowired() {
		// TODO Auto-generated constructor stub
	}
	
	private HelloWorld helloWorld;
	

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public static void main(String[] args) {
	  	 
		new TestAutowired().getHelloWorld().getMessage();
	   }
}


