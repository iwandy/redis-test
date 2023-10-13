package cn.wolfcode.redis.Service.Impl;

import cn.wolfcode.redis.Service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public Long incrementId(String id) {
        return template.opsForValue().increment(id) ;
    }
}
