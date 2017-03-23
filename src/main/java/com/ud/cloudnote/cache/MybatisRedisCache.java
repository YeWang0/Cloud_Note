package com.ud.cloudnote.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.ibatis.cache.Cache;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.ud.cloudnote.util.RedisUtil;
import com.ud.cloudnote.util.SerializeUtil;

public class MybatisRedisCache implements Cache {
//	private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class); 
	/** The ReadWriteLock. */ 
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private String id;
	
	public MybatisRedisCache(final String id) {  
		if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);
		this.id = id;
    }  
	
	public String getId() {
		return this.id;
	}
	public void putObject(Object key, Object value) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"###=###"+value);
		RedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
	}

	@SuppressWarnings("finally")
	public Object getObject(Object key) {
		Object value = null;
		value = SerializeUtil.unserialize(RedisUtil.getJedis().get(SerializeUtil.serialize(key.toString())));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>getObject:"+key+"###=###"+value);
		return value;
	}

	public Object removeObject(Object key) {
		return RedisUtil.getJedis().expire(SerializeUtil.serialize(key.toString()),0);
	}

	public void clear() {
		RedisUtil.getJedis().flushDB();
	}

	public int getSize() {
		return Integer.valueOf(RedisUtil.getJedis().dbSize().toString());
	}

	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
	
}