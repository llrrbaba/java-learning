package cn.rocker.test;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: rocker
 * @create: 2020-01-09 12:29
 * @since:
 **/
public class DateTest {


    @Test
    public void test(){
        AAA aaa = new AAA();
        System.out.println(ObjectSizeCalculator.getObjectSize(aaa));

//        long objectSize = ObjectSizeCalculator.getObjectSize(nowDate);
//        System.out.println(objectSize);
//
//        long intSize = ObjectSizeCalculator.getObjectSize(1);
//        System.out.println(intSize);
//
//        long longSize = ObjectSizeCalculator.getObjectSize(1L);
//        System.out.println(longSize);

    }

}

class AAA{
    long a = 1L;
}
