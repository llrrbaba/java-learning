package cn.rocker.juc.future.completablefuture3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author rocker
 * @date 2019/12/04 23:41
 * @since V1.0
 */
@Slf4j
public class AllofDemo {

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        log.info("start:{}", start);

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("future1:{}", 111);
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("future2:{}", 222);
        });

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("future3:{}", 333);
        });

        CompletableFuture.allOf(future1, future2, future3).whenComplete((v,t) -> {
            log.info("all done");
        });

        System.in.read();

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture
//                .allOf(future1, future2, future3)
//                .thenApply(v ->
//                        Stream.of(future1, future2, future3)
//                                .map(CompletableFuture::join)
//                                .collect(Collectors.toList()))
////                              .collect(Collectors.joining(" ")))
//                .thenAccept(str -> log.info("result:{}", str));
//        voidCompletableFuture.get();
        long end = System.currentTimeMillis();
        log.info("duration:{}", end - start);
    }

}
