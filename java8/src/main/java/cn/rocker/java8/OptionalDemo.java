package cn.rocker.java8;

import org.junit.Test;

import java.util.Optional;

/**
 *
 *
 * @author: zhichao.cheng@17xue.com
 * @create: 2020-05-08 11:35
 * @since:
 */
public class OptionalDemo {

    @Test
    public void testNull(){
        Object o = Optional.ofNullable(2).orElse(1);
        System.out.println(o);
    }

}