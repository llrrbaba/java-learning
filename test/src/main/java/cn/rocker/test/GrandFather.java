package cn.rocker.test;

/**
 * @author: zhichao.cheng@17xue.com
 * @create: 2020-05-14 16:29
 * @since:
 */
public class GrandFather {

    GrandFather(){
        System.out.println(getClass());
    }

    public static void main(String[] args) {
        Son son = new Son();
    }

}