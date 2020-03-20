package cn.rocker.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: chengzc
 * @create: 2020-03-14 15:27
 * @since:
 **/
public class GenericTest<T> {


    public static void main(String[] args) {
        GenericTest<Thread> stringGenericTest = new GenericTest<Thread>(){};
        Type type = ((ParameterizedType) stringGenericTest.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type);
    }

    public Class<T> getTClass()
    {
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }


    @Test
    public void test(){
        System.out.println("say:" + say(1,2,3,4,5,6,7));
    }


    private String say(int... a){
        if(a.length > 0){
            List<Integer> list = new ArrayList<>();
            for (int i : a) {
                list.add(i);
            }
            return StringUtils.join(list, "|");
        }
        return null;
    }


    private String hel(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        return StringUtils.join(strings,"#");
    }

}


