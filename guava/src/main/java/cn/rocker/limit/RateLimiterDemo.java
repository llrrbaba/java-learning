package cn.rocker.limit;

import com.alibaba.fastjson.JSONArray;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * guava 限流实现 {@link RateLimiter}
 *
 * @author: rocker
 * @create: 2019-12-30 12:46
 * @since:
 **/
@Slf4j
public class RateLimiterDemo {
    RateLimiter rateLimiter = RateLimiter.create(1);

    @Test
    public void test(){
        RateLimiter rateLimiter = RateLimiter.create(1);
        for(int i = 1; i < 10; i++ ) {
            double waitTime = rateLimiter.acquire(1);
            log.info("acq:{}, waitTime:{}", i, waitTime);
        }
    }

    @Test
    public void test2(){
        JSONArray objects = JSONArray.parseArray("\\{\\}");
        System.out.println(objects.size());
    }


    private void limit(){
        double acquire = rateLimiter.acquire(1);
        log.info("获取到令牌了, acquire:{}", acquire);
    }


    @Test
    public void test333(){
        List<CompareObject> list = new ArrayList<>();

        CompareObject compareObject1 = new CompareObject();
        compareObject1.setId(1);
        list.add(compareObject1);
        CompareObject compareObject2 = new CompareObject();
        compareObject2.setId(2);
        list.add(compareObject2);
        CompareObject compareObject3 = new CompareObject();
        compareObject3.setId(3);
        list.add(compareObject3);
        CompareObject compareObject4 = new CompareObject();
        compareObject4.setId(1);
        list.add(compareObject4);

        System.out.println(list);

        list = list.stream().distinct().collect(Collectors.toList());

        System.out.println(list);
    }

}
