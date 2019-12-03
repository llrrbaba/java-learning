package cn.rocker.juc.future.completablefuture2;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: rocker
 * @create: 2019-12-03 12:56
 * @since:
 **/
public class CompletableFutureCompose {

    public static Integer calc(Integer para){
        return para / 2;
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> calc(i)))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        future.get();
    }



}
