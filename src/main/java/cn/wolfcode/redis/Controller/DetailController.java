package cn.wolfcode.redis.Controller;

import cn.wolfcode.redis.Service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @PostMapping ("/incr")
    public Integer incr(String id){
        Long number  = detailService.incrementId(id);
        return number.intValue();
    }
}