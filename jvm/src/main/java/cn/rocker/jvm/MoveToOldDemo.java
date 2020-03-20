package cn.rocker.jvm;

/**
 * @author rocker
 * @date 2020/03/12 15:46
 * @since V1.0
 */
public class MoveToOldDemo {

    public static void main(String[] args) {
        // 第一次 GC
        byte[] bytes1 = new byte[2 * 1024 * 1024];
        bytes1 = new byte[2 * 1024 * 1024];
        bytes1 = new byte[2 * 1024 * 1024];
        bytes1 = null;

        byte[] bytes2 = new byte[128 * 1024];
        byte[] bytes3 = new byte[2 * 1024 * 1024];

        //第二次 GC
//        bytes3 = new byte[2 * 1024 * 1024];
//        bytes3 = new byte[2 * 1024 * 1024];
//        bytes3 = new byte[128 * 1024];
//        bytes3 = null;
//
//        byte[] bytes4 = new byte[2 * 1024 * 1024];
    }

}
