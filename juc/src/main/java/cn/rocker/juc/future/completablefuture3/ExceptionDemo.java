package cn.rocker.juc.future.completablefuture3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author: chengzc
 * @create: 2019-12-05 12:27
 * @since:
 **/
@Slf4j
public class ExceptionDemo {

    @Test
    public void test1() {
        CompletableFuture.supplyAsync(() -> "hello world")
                .thenApply(s -> {
                    s = null;
                    int length = s.length();
                    return length;
                }).thenAccept(i -> System.out.println(i))
                .exceptionally(t -> {
                    log.error("error");
                    System.out.println("Unexpected error:" + t);
                    return null;
                });
    }


    @Test
    public void test2(){
        CompletableFuture.supplyAsync(() -> "hello world")
                .thenApply(s -> {
                    s = null;
                    int length = s.length();
                    return length;
                }).thenAccept(i -> System.out.println(i))
                .whenComplete((result, throwable) -> {

                    if (throwable != null) {
                        System.out.println("Unexpected error:"+throwable);
                    } else {
                        System.out.println(result);
                    }

                });
    }

}
