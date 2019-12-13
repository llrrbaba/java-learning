package cn.rocker.juc.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @author: rocker
 * @create: 2019-12-05 17:24
 * @since:
 **/
public class ForLoopCalculator implements Calcultor {

    @Override
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }

    @Test
    public void test(){
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calcultor calculator = new ForLoopCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result);
    }
}
