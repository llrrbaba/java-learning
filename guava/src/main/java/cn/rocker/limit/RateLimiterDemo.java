package cn.rocker.limit;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * guava 限流实现 {@link RateLimiter}
 *
 * @author: rocker
 * @create: 2019-12-30 12:46
 * @since:
 **/
@Slf4j
public class RateLimiterDemo {

    @Test
    public void test(){
        RateLimiter rateLimiter = RateLimiter.create(1);
        for(int i = 1; i < 10; i++ ) {
            double waitTime = rateLimiter.acquire(1);
            log.info("acq:{}, waitTime:{}", i, waitTime);
        }
    }

}
