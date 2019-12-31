package com.chang.algorithm.atguigu.java8;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI {
    //创建Stream
    @Test
    public void test1(){
        //1.Collection提供了两个方法stream() 与 parallelStream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        //2.通过Arrays的stream（）获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //3.通过Stream类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        //4.创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        //生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);
    }

    //2. 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    /*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

    //内部迭代：迭代操作 Stream API 内部完成
    @Test
    public void test2(){
        //所有的中间操作不会做任何的处理
        Stream<Employee> stream = emps.stream()
                .filter(e -> {
                    return e.getAge() < 35;
                });
        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test3(){
        Iterator<Employee> it = emps.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void test4(){
        emps.stream()
                .filter(e->e.getSalary()>=5000).limit(2).forEach(System.out::println);
        System.out.println("--------------");
        emps.stream()
                .filter(e->e.getSalary()>=5000).skip(2).forEach(System.out::println);
    }

    @Test
    public void test5(){
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test6(){
        emps.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);
        System.out.println("-----");
        emps.stream()
                .sorted((x,y)->{
                    if (x.getAge()==y.getAge()){
                        return x.getName().compareTo(y.getName());
                    }else {
                        return Integer.compare(x.getAge(),y.getAge());
                    }
                }).forEach(System.out::println);
    }

    //3. 终止操作
	/*
		allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值

		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
	@Test
    public void test7(){
        boolean b1 = emps.stream()
                .allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);
        boolean b2 = emps.stream()
                .anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b2);
        boolean b3 = emps.stream()
                .noneMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b3);
    }
    @Test
    public void test8(){
        Optional<Employee> op = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();

        System.out.println(op.get());

        System.out.println("--------------------------------");

        Optional<Employee> op2 = emps.parallelStream()
                .filter((e) -> e.getStatus().equals(Status.BUSY))
                .findAny();
        System.out.println(op2.get());
    }

    @Test
    public void test9(){
        long count = emps.stream().filter(e -> e.getStatus().equals(Status.BUSY)).count();
        System.out.println(count);

        Optional<Double> op = emps.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println(op.get());

        Optional<Employee> op2 = emps.stream().min((x,y)->Double.compare(x.getSalary(),y.getSalary()));
        System.out.println(op2.get());
        //注意：流进行了终止操作后，不能再次使用
    }

    @Test
    public void test10(){
	 List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	 Integer sum = list.stream().reduce(0,(x,y)->x+y);
     System.out.println(sum);
     System.out.println("------");
     Optional<Double> op = emps.stream()
             .map(Employee::getSalary)
             .reduce(Double::sum);
        System.out.println(op.get());
    }

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test11(){
	    List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
	    list.forEach(System.out::println);
        System.out.println("------------");
        Set<String> set = emps.stream().map(Employee::getName).collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("-------");
        HashSet<String> collect = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        collect.forEach(System.out::println);
    }

    @Test
    public void test12(){
	    Optional<Double> max = emps.stream().map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compareTo));
        System.out.println(max.get());

        Optional<Employee> op = emps.stream().collect(Collectors.minBy((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())));
        System.out.println(op.get());

        Double sum = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        Double avg = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        Long count = emps.stream().collect(Collectors.counting());
        System.out.println(count);

        DoubleSummaryStatistics dss = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getSum());
    }

    //分组
    @Test
    public void test13(){
        Map<Status, Map<String, List<Employee>>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() > 60) {
                return "老年";
            } else if (e.getAge() >= 35) {
                return "中年";
            } else {
                return "成年";
            }
        })));
        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void test14(){
        Map<Boolean, List<Employee>> map = emps.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
        System.out.println(JSON.toJSONString(map));

        String str = emps.stream().map(Employee::getName).collect(Collectors.joining(",", "-----", "-----"));
        System.out.println(str);

        Optional<Double> sum = emps.stream().map(Employee::getSalary).collect(Collectors.reducing(Double::sum));
        System.out.println(sum.get());
    }
}
