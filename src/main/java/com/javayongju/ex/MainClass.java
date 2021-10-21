package com.javayongju.ex;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericXmlApplicationContext gctx = (GenericXmlApplicationContext)ctx;
		gctx.load("applicationCTX.xml");
		gctx.refresh();
		
		AdminConnection adminConnection = gctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("admin id = " + adminConnection.getAdminId());
		System.out.println("admin pw = " + adminConnection.getAdminPw());
		
		gctx.close();
		ctx.close();
	}

}
