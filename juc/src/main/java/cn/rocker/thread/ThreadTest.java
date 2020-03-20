package cn.rocker.thread;

/**
 * @author rocker
 * @date 2020/03/12 21:40
 * @since V1.0
 */
public class ThreadTest {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a Child thread");
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

}
