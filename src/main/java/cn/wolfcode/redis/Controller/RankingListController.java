package cn.wolfcode.redis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/rankingList")
public class RankingListController {

    @Autowired
    private StringRedisTemplate template;

    @PostMapping("/increment")
    public String incr(String id) {
        template.opsForZSet().incrementScore("ranking-list", id,1);

        Set<ZSetOperations.TypedTuple<String>> tuples = template.opsForZSet().reverseRangeWithScores("ranking-list", 0, -1);
        StringBuffer ranking = new StringBuffer();
        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
            ranking.append(tuple.getValue() + " : " + String.format("%.0f", tuple.getScore()) + "  ");
        }
        return ranking.toString();
    }
}
