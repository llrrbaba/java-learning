package cn.rocker.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: chengzc
 * @create: 2020-03-06 20:33
 * @since:
 **/
@Table(name = "t_test")
public class AnnotationTest {


    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Class<AnnotationTest> clazz = AnnotationTest.class;

        if(clazz.isAnnotationPresent(Table.class)){
            // 获取 "类" 上的注解
            Table getAnnotation = clazz.getAnnotation(Table.class);
            System.out.println("\"类\"上的注解值获取到第一个 ："
                    + getAnnotation.name());

            InvocationHandler h = Proxy.getInvocationHandler(getAnnotation);
            Field hField = h.getClass().getDeclaredField("memberValues");
            hField.setAccessible(true);
            Map memberValues = (Map) hField.get(h);
            memberValues.put("name", "t_ddd");
            System.out.println("\"类\"上的注解值获取到第一个 ："
                    + getAnnotation.name());
        }
    }


    @Test
    public void test2(){
        int a = 0;
        int b = 1;
        int c = 2;

        int d = c = b = a;
        System.out.println(d);
    }

}
