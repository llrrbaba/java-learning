package cn.rocker.juc.future.completablefuture3;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author rocker
 * @date 2019/12/04 23:41
 * @since V1.0
 */
public class AllofDemo {

    @Test
    public void test() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "tony");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "cafei");

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "aaron");

        CompletableFuture.allOf(future1, future2, future3)
                .thenApply(v ->
                        Stream.of(future1, future2, future3)
                                .map(CompletableFuture::join)
//                                .collect(Collectors.joining(" ")))
                                .collect(Collectors.toList()))
                .thenAccept(System.out::print);
    }

}
