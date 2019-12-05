package cn.rocker.juc.future.completablefuture3;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: rocker
 * @create: 2019-12-05 12:24
 * @since:
 **/
public class EitherDemo {
    @Test
    public void test() {
        Random random = new Random();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "from future1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "from future2";
        });

        CompletableFuture<Void> future = future1.acceptEither(future2, str -> System.out.println("The future is " + str));

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
