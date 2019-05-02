package sc.redis.cache.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisCacheSerializeConfiguration {

//	/**
//	 *二选一
//	 * 设置 redis 数据默认过期时间 设置@cacheable 序列化方式
//	 * 
//	 * @return
//	 */
//	@Bean
//	public RedisCacheConfiguration redisCacheConfiguration() {
//		RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
//		configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
//				.entryTtl(Duration.ofDays(30));
//		configuration.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()));
//		return configuration;
//	}

	/**
	 * 二选一
	 * 设置 redis 数据默认过期时间 设置@cacheable 序列化方式
	 * 
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(30))
				.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
				.disableCachingNullValues();
		RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).cacheDefaults(config)
				.transactionAware().build();
		System.out.println("自定义RedisCacheManager加载完成");
		return redisCacheManager;
	}

	private RedisSerializer<String> keySerializer() {
		return new StringRedisSerializer();
	}

	private RedisSerializer<Object> valueSerializer() {
		return new GenericJackson2JsonRedisSerializer();
	}

}