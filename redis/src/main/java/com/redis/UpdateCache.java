package com.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.data.redis.core.RedisTemplate;

public class UpdateCache implements MethodInterceptor{
	
	private static RedisTemplate<Serializable, Object> redisTemplate;
	
	public static RedisTemplate<Serializable, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public static void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
		UpdateCache.redisTemplate = redisTemplate;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		redisTemplate.expire("userslist", 1, TimeUnit.MILLISECONDS);
		invocation.proceed();//更新时必须调用proceed
		return 1;
	}
}
