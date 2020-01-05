package com.chang.java9Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @User: chang
 */
public class OptionalTest {
    //Optional类中提供了转换为Stream的方法：stream()
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");
        Optional<List<String>> list1 = Optional.ofNullable(list);
        Stream<String> stringStream = list1.stream().flatMap(x -> x.stream());
        stringStream.forEach(System.out::println);
    }
}
