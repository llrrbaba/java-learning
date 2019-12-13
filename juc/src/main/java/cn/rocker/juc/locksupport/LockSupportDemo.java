package cn.rocker.juc.locksupport;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 *
 *
 * @author: rocker
 * @create: 2019-12-13 19:01
 * @since:
 **/
public class LockSupportDemo {

    @Test
    public void testUnPark() throws InterruptedException {
        Thread thread1 = new Thread(new Task1());
        thread1.start();

        Thread.sleep(6000);

        Thread thread2 = new Thread(new Task2(thread1));
        thread2.start();
    }

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread thread1 = new Thread(new Task1());
        thread1.start();

        Thread.sleep(6000);

        Thread thread3 = new Thread(new Task3(thread1));
        thread3.start();
    }



}

class Task1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Task1 begin park!");
        LockSupport.park();
        System.out.println("Task1 end park!");
    }
}

class Task2 implements Runnable{

    private Thread runner;

    public Task2(Thread thread) {
        this.runner = thread;
    }

    @Override
    public void run() {
        System.out.println("Task2 begin unPark!");
        LockSupport.unpark(runner);
        System.out.println("Task2 end unPark!");
    }
}

class Task3 implements Runnable{

    private Thread runner;

    public Task3(Thread thread) {
        this.runner = thread;
    }

    @Override
    public void run() {
        System.out.println("Task3 begin interrupt!");
        LockSupport.unpark(runner);
        System.out.println("Task3 end interrupt!");
    }
}
