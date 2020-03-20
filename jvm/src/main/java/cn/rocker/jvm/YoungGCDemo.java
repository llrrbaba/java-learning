package cn.rocker.jvm;

/**
 * VM Options:
 * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *
 * @author rocker
 * @date 2020/03/12 14:55
 * @since V1.0
 */
public class YoungGCDemo {

    public static void main(String[] args) {
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwww");
        byte[] bytes1 = new byte[1024 * 1024];
        bytes1 = new byte[1024 * 1024];
        bytes1 = new byte[1024 * 1024];
        bytes1 = null;

        byte[] bytes2 = new byte[2 * 1024 * 1024];
    }

}
