package cn.rocker.juc.future.completablefuture2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: rocker
 * @create: 2019-12-03 11:59
 * @since:
 **/
@Slf4j
public class CompletableFutureDealingException {

    public static Integer calc(Integer para) {
        return para / 0;
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
                .exceptionally(ex -> {
                    log.error("error for :{}", ex.getMessage());
                    return 0;
                })
                .thenApply(integer -> Integer.toString(integer))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        future.get();
    }

}
