package cn.rocker.juc.future.completablefuture2;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author: rocker
 * @create: 2019-12-03 11:33
 * @since:
 **/
public class CompletableFutureOriginalUse implements Runnable {

    CompletableFuture<Integer> re = null;

    public CompletableFutureOriginalUse(CompletableFuture<Integer> re) {
        this.re = re;
    }

    public CompletableFutureOriginalUse() {
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = re.get() * re.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(myRe);
    }

    @Test
    public void test1() throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        new Thread(new CompletableFutureOriginalUse(future)).start();
        Thread.sleep(1000);
        future.complete(60);
    }
}
