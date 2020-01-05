package com.chang.java9Test;

import org.junit.Test;

import java.util.*;

/**
 * @User: chang
 */
public class CollectionMapTest {
    //jdk 8 以及之前：创建一个只读特点的集合
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Lilei");
        list.add("HanMeimei");
        //调用Collections中的方法，将list变为只读的
        List<String> newList = Collections.unmodifiableList(list);
//        newList.add("Tim");//不能执行，否则报异常
        //遍历：jdk 8
        newList.forEach(System.out::println);
    }

    //jdk 8 以及之前：创建一个只读特点的集合
    @Test
    public void test2(){
        //List:
        List<Integer> list = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
//        list.add(4);
        //Set:
        Set<Integer> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3)));
//        set.add(4);
        //Map:
        Map<Object, Object> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("Tom", 78);
                put("Jerry", 88);
                put("Tim", 68);
            }
        });
        map.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    //jdk 9 中：创建一个只读特点的集合
    @Test
    public void test3(){
        List<Integer> list = List.of(1,3,4);
        Set<Integer> set = Set.of(2, 3, 4);
        Map<String, Integer> map = Map.of("Tom", 123, "Jerry", 22);
        Map<String, Integer> map1 = Map.ofEntries(Map.entry("Tom", 12), Map.entry("Jerry", 22));

    }
}
