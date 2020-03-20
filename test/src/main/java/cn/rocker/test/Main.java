package cn.rocker.test;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chengzc
 * @create: 2020-03-14 15:32
 * @since:
 **/
public class Main<T> {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Main<String> foo = new Main<String>() {
        };
        // 在类的外部这样获取
        Type type = ((ParameterizedType) foo.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type);

    }


    @Test
    public void main222() {

        MyThread myThread1 = new MyThread();
        myThread1.setName("线程1");
        MyThread myThread2 = new MyThread();
        myThread1.setName("线程2");

        myThread1.start();
        myThread2.start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            lock.lock();
            System.out.println("线程1加锁");
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }





}