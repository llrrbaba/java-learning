package cn.rocker.juc.future.completablefuture;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 测试{@link CompletableFuture}
 *
 * @author: rocker
 * @create: 2019-11-29 18:45
 * @since:
 **/
public class TestCase {

    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("TMall"),
            new Shop("JingDong"),
            new Shop("Messi"),
            new Shop("Ronaldo"),
            new Shop("Rooney"),
            new Shop("Henry"));

    public List<String> findPricesWithStream(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPriceSync(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesWithParallelStream(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPriceSync(product)))
                .collect(Collectors.toList());
    }



    public List<String> findPricesWithCompletableFuture(String product) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                thread.setDaemon(true);
                return thread;
            }
        });
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPriceSync(product)), executorService))
                .collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    @Test
    public void test2() {
        long start = System.nanoTime();
//        System.out.println(findPricesWithStream("myPhone27S"));
//        System.out.println(findPricesWithParallelStream("myPhone27S"));
        System.out.println(findPricesWithCompletableFuture("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("done in " + duration + "ms");
    }

    @Test
    public void test1() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsyncV1("my favorite product");
        long invocatime = (System.nanoTime() - start) / 1000000;
        System.out.println("Invocation returned after " + invocatime + "ms");

        doSomethingElse();

        try {
            double price = futurePrice.get(2, TimeUnit.SECONDS);
            System.out.printf("price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Price returned after " + retrievalTime + "ms");
    }

    private void doSomethingElse() {
        try {
            Thread.sleep(2000);
            System.out.println("yes, i pretended to do something, so boring");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
