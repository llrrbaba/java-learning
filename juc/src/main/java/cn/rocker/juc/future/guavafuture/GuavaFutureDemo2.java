package cn.rocker.juc.future.guavafuture;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author: rocker
 * @create: 2019-12-03 20:48
 * @since:
 **/
public class GuavaFutureDemo2 {

    @Test
    public void test() throws InterruptedException {
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<String> task = listeningExecutorService.submit(new RealData("x"));

        Futures.addCallback(task, new FutureCallback<String>() {
            @Override
            public void onSuccess(@NullableDecl String s) {
                System.out.println("异步处理成功:" + s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("异步处理失败 e=" + throwable);
            }
        }, MoreExecutors.directExecutor());

        System.out.println("test thread done...");
        Thread.sleep(3000);
    }
}
