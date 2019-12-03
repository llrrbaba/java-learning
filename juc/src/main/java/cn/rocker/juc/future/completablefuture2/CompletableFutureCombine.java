package cn.rocker.juc.future.completablefuture2;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: rocker
 * @create: 2019-12-03 13:04
 * @since:
 **/
public class CompletableFutureCombine {

    public static Integer calc(Integer para){
        return para / 2;
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> calc(50));
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> calc(25));

        CompletableFuture<Void> combinedFuture = future1.thenCombine(future2, (i, j) -> (i + j))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        combinedFuture.get();
    }

}
