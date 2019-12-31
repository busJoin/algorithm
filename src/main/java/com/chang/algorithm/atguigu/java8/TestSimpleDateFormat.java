package com.chang.algorithm.atguigu.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //会出现多线程问题
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20161111");
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> result = new ArrayList<>();
        for (int i=0;i<10;i++){
            result.add(pool.submit(task));
        }
        for (Future<Date> future:result){
            System.out.println(future.get());
        }
        pool.shutdown();*/
        //解决多线程问题
        /*Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("20161111");
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<Date> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();*/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                LocalDate ld = LocalDate.parse("20191111",dtf);
                return ld;
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
