package cn.rocker.juc.future.completablefuture3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author: rocker
 * @create: 2019-12-04 20:45
 * @since:
 **/
@Slf4j
public class WhenCompleteDemo1 {

    @Test
    public void test() throws IOException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();

        new Thread(() -> {
            // 子线程A启动
            log.info("子线程A启动");
            try {
                log.info("子线程A沉睡5s");
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("子线程A令future完成");
            // 当子线程A执行到f.complete的时候，会去看是否有注册好的f的then或者when（非async的），如果有的话，会顺次去执行。
            f.complete(100);
            log.info("子线程A结束");
        }).start();;


        // 当前线程（主线程）执行到这里的时候，如果子线程还没有执行到f.complete(100)，
        // 那么当前线程会把whenComplete事件注册起来，并且说好哪个线程执行了f.complete(100)，
        // 哪个线程就负责执行whenComplete的内容。
        // 如果当前线程（主线程）执行到这里的时候，f.complete(100)已经被其他线程执行完毕了。
        // 那么只有当前线程自己来执行whenComplete里面的内容了。
        f.whenComplete((i, ex) -> {
            // 这个场景下，whenComplete的回调的执行线程会是子线程A
            log.info("do something after complete begin");
            try {
                log.info("沉睡10s");
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("do something after complete end");
        });


        log.info("main over");
        System.in.read();
    }

    /**
     *  可以看下最后的输出情况
     *  do something after complete begin
     *  沉睡10s
     *  do something after complete end
     *  这三条，是由 [Thread-0] 输出的
     *
     *  INFO [Thread-0] (WhenCompleteDemo.java:23) - 子线程A启动
     *  INFO [main] (WhenCompleteDemo.java:55) - main over
     *  INFO [Thread-0] (WhenCompleteDemo.java:25) - 子线程A沉睡5s
     *  INFO [Thread-0] (WhenCompleteDemo.java:30) - 子线程A令future完成
     *  INFO [Thread-0] (WhenCompleteDemo.java:44) - do something after complete begin
     *  INFO [Thread-0] (WhenCompleteDemo.java:46) - 沉睡10s
     *  INFO [Thread-0] (WhenCompleteDemo.java:51) - do something after complete end
     *  INFO [Thread-0] (WhenCompleteDemo.java:33) - 子线程A结束
     */

}
