package cn.rocker.juc.future;

import java.util.concurrent.*;

/**
 * 使用 {@link Callable} 和 {@link Future} 获取结果
 *
 * @author: rocker
 * @create: 2019-11-29 15:11
 * @since:
 **/
public class CallableAndFutureDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task1 task = new Task1();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}

class Task1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        return sum;
    }

}
