package sc.redis.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 更多资源关注公众号： java乐园
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableCaching // 启动缓存
@MapperScan(basePackages="sc.redis.cache.dao")
public class RedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}
	
}
