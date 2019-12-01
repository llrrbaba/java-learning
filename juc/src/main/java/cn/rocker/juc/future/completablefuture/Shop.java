package cn.rocker.juc.future.completablefuture;

import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: rocker
 * @create: 2019-11-29 17:54
 * @since:
 **/
@Data
public class Shop {

    /**
     * 同步地调用，根据指定商品名称返回商品价格
     *
     * @param product 商品名称
     * @return
     */
    public double getPriceSyncV1(String product) {
        return calculatePrice(product);
    }

    /**
     * 同步地调用，根据指定商品名称返回商品价格
     *
     * @param product 商品名称
     * @return
     */
    public String getPriceSyncV2(String product) {
        Random random = new Random();
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public Future<Double> getPriceAsyncV1(String product) {
        // 创建 CompletableFuture对象，它包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                // 在另一个线程中以异步方式执行计算
                double price = calculatePrice(product);

                // TODO 用于提示错误的异常会被限制在试图计算商品价格的当前线程的范围内，
                // TODO 最终会杀死该线程，而这会导致等待 get 方法返回结果的客户端永久地被阻塞。
                int errotInt = 1 / 0;

                // 需要长时间计算的任务结束并得出结果时，设置future的返回值
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();

        // 无需等待还未结束的计算，直接返回future对象
        return futurePrice;
    }

    public Future<Double> getPriceAsyncV2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    /**
     * 调用模拟延时，返回一个自定义价格
     *
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 模拟延迟一秒种的方法
     */
    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 模拟延迟0.5-2秒种的方法
     */
    public static void randomdelay() {
        Random random = new Random();
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    private String name;

    public Shop(String name) {
        this.name = name;
    }
}
