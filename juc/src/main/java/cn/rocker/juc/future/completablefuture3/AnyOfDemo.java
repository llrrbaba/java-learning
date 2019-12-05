package cn.rocker.juc.future.completablefuture3;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: chengzc
 * @create: 2019-12-05 11:07
 * @since:
 **/
public class AnyOfDemo {

    @Test
    public void test() {
        Random rand = new Random();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from future2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from future3";
        });

        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2, future3);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
