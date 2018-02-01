package com.websocket;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware{
	
	public static ApplicationContext applicationcontext;
	
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationcontext=arg0;
	}
	
}
