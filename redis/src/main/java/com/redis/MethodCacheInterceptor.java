package com.redis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.dao.UserDao;
import com.entity.Users;

public class MethodCacheInterceptor implements MethodInterceptor{
		
	private static RedisTemplate<Serializable, Object> redisTemplate;
	
	public static RedisTemplate<Serializable, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public static void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
		MethodCacheInterceptor.redisTemplate = redisTemplate;
	}

	/**
	 *  invoke的返回值等于此方法拦截的service方法的返回值
	 *  invocation 为拦截方法的对象
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if(redisTemplate.hasKey("userslist")) {
			System.out.println("redis里面查");
			ListOperations<Serializable,Object> operations=redisTemplate.opsForList();
			List<Users> userslist=new ArrayList<Users>();
			for(int i=0;i<operations.size("userslist");i++) {
				userslist.add((Users) operations.index("userslist", i));
			}
			return userslist;
		}
		System.out.println("数据库里面查");
		UserDao dao=(UserDao)SpringContextUtil.applicationcontext.getBean("UserDao");
		List<Users> userslist=new ArrayList<Users>();
		ListOperations<Serializable,Object> operations=redisTemplate.opsForList();
		userslist=dao.selectAll();
		for(int i=0;i<userslist.size();i++) {
			operations.rightPush("userslist", userslist.get(i));
		}
		redisTemplate.expire("userslist", 20, TimeUnit.SECONDS);//设置redis20s过期
		return userslist;
	}
}
