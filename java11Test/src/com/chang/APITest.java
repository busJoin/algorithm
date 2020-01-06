package com.chang;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @User: chang
 */
public class APITest {
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bbb");
        list.add("cc");
        list.add("DD");
        System.out.println(list);
    }

    @Test
    public void test2(){
        int[] arr = {1,23,4,5};
        List<String> list = Arrays.asList("aa", "yy");
        list.add("df");// 是一个不可以添加元素的集合

        // 集合的创建可以使用更简单的方式
        List<String> list2 = List.of("aa", "bbb", "cc", "DD");
    }

    // 集合中的一些增强的API
    @Test
    public void test3() {
        LocalDate localDate = LocalDate.of(2019, 1, 21);
        // 在添加重复元素时, 不是无法添加, 而是抛出异常
        //Set<Integer> set = Set.of(100, 50, 20, 30, 10, 8, 100, 8);
        Set<Integer> set = Set.of(100, 50, 20, 30, 10, 8);
        System.out.println(set.getClass());

        Stream<Integer> stream = Stream.of(50, 20, 30, 70);
    }

    @Test
    public void test(){
        Consumer<String> consumer = t -> System.out.println(t.toUpperCase());
        Consumer<String> consumer1 = (var t) -> System.out.println(t.toUpperCase());

        //错误的形式: 必须要有类型, 可以加上var
//        Consumer<String> consumer2 = (@Deprecated t) -> System.out.println(t.toUpperCase());
        //正确的形式:
        Consumer<String> consumer3 = (@Deprecated String t) -> System.out.println(t.toUpperCase());

    }
}
