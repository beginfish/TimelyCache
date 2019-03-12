package com.bamdow.framework;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class TimelyCacheInstance extends TimerTask implements TimelyCacheClient{

	private ConcurrentMap<String, Object> cacheMap = new ConcurrentHashMap<String, Object>();
	private ConcurrentMap<String, Long> expireMap = new ConcurrentHashMap<String, Long>();
	private final static long overdue = -2;
	private final static long persisted = -1;
	
	@Override
	public boolean put(String key, Object obj, long expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean put(String key, Object obj, TimeUnit timeUnit, long expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putIfAttend(String key, Object obj, long expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putIfAttend(String key, Object obj, TimeUnit timeUnit,
			long expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putIfAbsent(String key, Object obj, long expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putIfAbsent(String key, Object obj, TimeUnit timeUnit,
			long expire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean get(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long ttl(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long pttl(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long expire(String key, long timeseconds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long expire(String key, TimeUnit timeUnit, long exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long expireAt(String key, Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long incr(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long incrBy(String key, int dela) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long decr(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long decrBy(String key, int dela) {
		return 0;
	}

	private boolean validateExpire(String key){
		Long old = expireMap.get(key);
		if( old==null ) return false;
		if( old != null && old.intValue() == persisted){
			return true;
		}
		long expire = (expireMap.get(key)-System.currentTimeMillis())*1000;
		return expire>0?true:false;
	}
	
	@Override
	public void run() {
		 for( String key : expireMap.keySet() ){
			 if(!validateExpire(key)){
				 System.out.println("begin to remove:"+key);
				 remove(key);
			 }
		 }
	}

	@Override
	public int publish(String key, Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean subscribe(String key, TimelyCallback tcall) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean psubscribe(String pattern, TimelyCallback tcall) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int unsubscribe(String... key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int punsubscribe(String pattern) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
