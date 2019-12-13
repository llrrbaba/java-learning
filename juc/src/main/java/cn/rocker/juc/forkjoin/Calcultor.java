package cn.rocker.juc.forkjoin;

/**
 * @author: rocker
 * @create: 2019-12-05 17:24
 * @since:
 **/
public interface Calcultor {

    /**
     * 把传进来的所有numbers 做求和处理
     *
     * @param numbers
     * @return 总和
     */
    long sumUp(long[] numbers);

}
