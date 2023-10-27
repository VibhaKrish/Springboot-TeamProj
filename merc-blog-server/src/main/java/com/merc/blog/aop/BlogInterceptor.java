package com.merc.blog.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// aspect oriented programming 
@Configuration
@Aspect
public class BlogInterceptor {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.merc.blog.service.*.*(..))")
	public void serviceLog() {
		LOG.info("A method from a service class invoked.");
	}
	
	@Before("execution(* com.merc.blog.service.*.*(..))")
	public void serviceLogAfter() {
		LOG.info("A method from a service class completed.");
	}

}