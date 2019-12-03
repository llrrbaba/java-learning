package cn.rocker.juc.future.guavafuture;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author: rocker
 * @create: 2019-12-03 19:48
 * @since:
 **/
public class GuavaFutureDemo1 {

    @Test
    public void test() throws InterruptedException {
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<String> task = listeningExecutorService.submit(new RealData("x"));

        task.addListener(() -> {
            System.out.print("异步处理成功:");
            try {
                System.out.println(task.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, MoreExecutors.directExecutor());

        System.out.println("test thread done...");
        Thread.sleep(3000);
    }

}
