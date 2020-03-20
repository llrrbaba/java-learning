package cn.rocker.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: rocker
 * @create: 2020-03-15 17:09
 * @since:
 **/
public class LockSupportDemo {

    public static void main(String[] args) {
        System.out.println("begin park!");
        LockSupport.park();
        System.out.println("end park!");
    }

}
