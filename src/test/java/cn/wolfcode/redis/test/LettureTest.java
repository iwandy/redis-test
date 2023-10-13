package cn.wolfcode.redis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class LettureTest {


    @Autowired
    private StringRedisTemplate template;

    @Test
    public void testRedis() {
        template.delete("name");
        template.opsForValue().set("name", "dafei");
        System.out.println(template.opsForValue().get("name"));
    }

    @Test
    public void testDouble() {
        Double db = 3.0000;
        System.out.println(String.format("%.0f", db));
    }
}