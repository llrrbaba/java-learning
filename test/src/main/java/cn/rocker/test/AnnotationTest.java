package cn.rocker.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
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

    @Test
    public void testMap(){
        HashMap<String, String> map = new HashMap<>();
        String a = map.computeIfAbsent("2", str-> "c");
        System.out.println(a);
        System.out.println(map.get("2"));
    }


    @Test
    public void teseEnum(){
        System.out.println(EnumTest.AUTUMN.name());
        System.out.println(EnumTest.AUTUMN.ordinal());
        System.out.println(EnumTest.SPRING.ordinal());
        System.out.println(EnumTest.SPRING.toString());
        System.out.println(EnumTest.SPRING.name());
    }

    @Test
    public void testAtomicReference(){

        String initialReference = "initial value referenced";

        AtomicReference<String> atomicStringReference =
                new AtomicReference<String>(initialReference);

        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

    }

    @Test
    public void testStreamMap(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(5,"a","A"));
        students.add(new Student(2,"b","B"));
        students.add(new Student(3,"c","C"));

        System.out.println((students.stream().filter(student -> student.getAge() == 10).collect(Collectors.toList())).size());

        Map<Integer, Student> collect3 = students.stream().collect(Collectors.toMap(Student::getAge, Function.identity()));
        System.out.println(collect3);

        Map<Integer, Student> collect4 = students.stream().collect(Collectors.toMap(Student::getAge, Function.identity(), (l,r)-> l));
        System.out.println(collect4);

        Map<Integer, Student> collect5 = students.stream().collect(Collectors.toMap(Student::getAge, Function.identity(), (l,r)-> r));
        System.out.println(collect5);

    }


    @Test
    public void testAllMatch(){
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        integers1.add(5);

        List<Integer> integers2 = new ArrayList<>();
        integers2.add(1);
        integers2.add(2);
        integers2.add(3);
        integers2.add(4);

        boolean b = integers1.stream().allMatch(integers2::contains);
        System.out.println(b);


    }

}

@AllArgsConstructor
@Data
@ToString
class Student{
    private int age;
    private String namex;
    private String namey;
}
