package cn.rocker.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chengzc
 * @create: 2020-03-14 11:40
 * @since:
 **/
@Slf4j
public class ThreadState1 {

    Lock lock = new ReentrantLock();

    @Test
    public void test() throws InterruptedException {
        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread.sleep(1000);

        thread1.interrupt();
        System.out.println("thread1被中断");
        System.out.println("thread1 " + thread1.getState());
    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                Thread.sleep(30000000);
            } catch (Exception e) {
                log.error("中断了", e);
            } finally {
//                lock.unlock();
            }
        }
    }


}
