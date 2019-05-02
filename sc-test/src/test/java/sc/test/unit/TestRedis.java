package sc.test.unit;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import sc.test.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    private static final Logger log = LoggerFactory.getLogger(TestRedis.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void get() {
        // 测试线程安全
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        IntStream.range(0, 1000).forEach(i ->
//                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
//        );
        stringRedisTemplate.opsForValue().set("key", "{'name':'huangjinjin', 'age':30}");
        final String value = stringRedisTemplate.opsForValue().get("key");
        log.info("[字符缓存结果] - [{}]", value);
        String key = "manage:user:1";
        User u = new User();
        u.setId(1L);
        u.setAge(30);
        u.setPosition("cto");
        u.setUserName("good boy");
        redisCacheTemplate.opsForValue().set(key, u);
        //从缓存获取User对象
        final User user = (User) redisCacheTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - userName={}, age={}, position={}", //
        		user.getUserName(), user.getAge(), user.getPosition());
    }
}