package cn.rocker.juc.future.completablefuture3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author: rocker
 * @create: 2019-12-05 11:07
 * @since:
 **/
@Slf4j
public class AnyOfDemo {

    @Test
    public void test() {
        Random rand = new Random();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("from future1");
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("from future2");
        });
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("from future3");
        });

        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2, future3);

        try {
            // 阻塞式地等待
            // System.out.println(future.get());

            // 非阻塞式地回调
            future.whenComplete((v,t) -> log.info("any done"));
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
