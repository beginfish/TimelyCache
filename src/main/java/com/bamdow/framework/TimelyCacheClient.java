package com.bamdow.framework;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface TimelyCacheClient {

	public boolean put(String key,Object obj,long expire);
	
	public boolean put(String key,Object obj,TimeUnit timeUnit,long expire);
	
	public boolean putIfAttend(String key,Object obj,long expire);
	
	public boolean putIfAttend(String key,Object obj,TimeUnit timeUnit,long expire);
	
	public boolean putIfAbsent(String key,Object obj,long expire);
	
	public boolean putIfAbsent(String key,Object obj,TimeUnit timeUnit,long expire);
	
	public boolean get(String key);
	
	public boolean remove(String key);
	
	public long ttl(String key);
	
	public long pttl(String key);
	
	public long expire(String key,long timeseconds);
	
	public long expire(String key,TimeUnit timeUnit,long exp);
	
	/**
	 * 有效期截止日期
	 * @param key
	 * @param date
	 * @return
	 */
	public long expireAt(String key,Date date);
	
	public long incr(String key);
	
	public long incrBy(String key,int dela);
	
	public long decr(String key);
	
	public long decrBy(String key,int dela);
	
	/**
	 * 发布信息给 key频道
	 * @param key
	 * @param obj
	 * @return
	 */
	public int publish(String key,Object obj);
	
	/**
	 * 订阅 key频道
	 * @param key 频道
	 * @return
	 */
	public boolean subscribe(String key,TimelyCallback tcall);
	
	public boolean psubscribe(String pattern,TimelyCallback tcall);
	
	public int unsubscribe(String... key);
	
	public int punsubscribe(String pattern);
	
}
