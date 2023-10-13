package cn.wolfcode.redis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class DetailController {

    @Autowired
    private StringRedisTemplate template;

    @PostMapping ("/incr")
    public Integer incr(String id){
        Long number  = template.opsForValue().increment(id);
        return number.intValue();
    }
}