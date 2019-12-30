package cn.rocker;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;


/**
 * @author: rocker
 * @create: 2019-12-23 12:35
 * @since:
 **/
@Slf4j
public class ExceptionDemo {

    Function<Integer,Integer> function = i -> i+1;

    @Test
    public void test(){
        String str = "hello";
        String ttt = "world";
        String s = str + System.getProperty("line.separator") + ttt;
        log.error(s);
    }

    private int getByPlusInput(int i, Function<Integer,Integer> convert){
        return convert.apply(i);
    }

}
