package com.cto51;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisTemplate<String, String> redisCacheTemplate;

	@Test
	public void stringTest() {
		// 设置
		redisCacheTemplate.opsForValue().set("testString", "公众号 聊点");
		// 获取
		System.out.println(redisCacheTemplate.opsForValue().get("testString"));
	}

	@Test
	public void expireTest() {
		// 设置
		redisCacheTemplate.opsForValue().set("testString", "公众号 聊点", 10, TimeUnit.SECONDS);
		// 获取
		System.out.println("存在testString = " + redisCacheTemplate.opsForValue().get("testString"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		// 获取
		System.out.println("不存在testString = " + redisCacheTemplate.hasKey("testString"));
	}

	@Test
	public void deleteTest() {
		// 设置
		redisCacheTemplate.opsForValue().set("testString", "公众号 聊点", 10, TimeUnit.SECONDS);
		// 获取
		System.out.println("存在testString = " + redisCacheTemplate.opsForValue().get("testString"));
		// 删除
		redisCacheTemplate.delete("testString");
		// 获取
		System.out.println("不存在testString = " + redisCacheTemplate.hasKey("testString"));
	}

	@Test
	public void listTest() {
		ListOperations<String, String> listOpr = redisCacheTemplate.opsForList();
		listOpr.leftPush("list", "java");
		listOpr.leftPush("list", "c#");
		listOpr.leftPush("list", "c++");
		listOpr.rightPush("list", "python");
		String value = (String) listOpr.leftPop("list");
		System.out.println("list value :" + value.toString());
		value = (String) listOpr.rightPop("list");
		System.out.println("list value :" + value.toString());
	}

	@Test
	public void hashTest() {
		HashOperations<String, String, String> hashOpr = redisCacheTemplate.opsForHash();
		hashOpr.put("redisKey", "key1", "java");
		hashOpr.put("redisKey", "key2", "c#");
		hashOpr.put("redisKey", "key3", "python");
		String value1 = hashOpr.get("redisKey", "key3");
		System.out.println("key1 = " + value1);
	}

	@Test
	public void setTest() {
		SetOperations<String, String> setOpr = redisCacheTemplate.opsForSet();
		setOpr.add("set", "java");
		setOpr.add("set", "c#");
		setOpr.add("set", "python");
		setOpr.add("set", "java");
		Set<String> set = setOpr.members("set");
		Iterator<String> items = set.iterator();
		while (items.hasNext()) {
			System.out.println(items.next());
		}
		System.out.println("-----------");
		ListOperations<String, String> listOpr = redisCacheTemplate.opsForList();
		listOpr.leftPush("listv", "java");
		listOpr.leftPush("listv", "c#");
		listOpr.leftPush("listv", "python");
		listOpr.leftPush("listv", "java");
		List<String> list = listOpr.range("listv", 0, -1);
		items = list.iterator();
		while (items.hasNext()) {
			System.out.println(items.next());
		}
	}

	@Test
	public void sortedSetTest() {
		ZSetOperations<String, String> zset = redisCacheTemplate.opsForZSet();
		zset.add("zset", "java", 1);
		zset.add("zset", "c#", 3);
		zset.add("zset", "python", 2);
		zset.add("zset", "c++", 4);
		Set<String> zsets = zset.range("zset", 0, -1);
		for (String value : zsets) {
			System.out.println(value);
		}
		System.out.println("------按照socre获取元素--------");
		Set<String> zsetB = zset.rangeByScore("zset", 0, 2);
		for (String value : zsetB) {
			System.out.println(value);
		}
	}

}
