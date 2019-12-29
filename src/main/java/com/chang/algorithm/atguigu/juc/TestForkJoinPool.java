package com.chang.algorithm.atguigu.juc;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class TestForkJoinPool {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> tast = new ForkJoinSumCalculate(0,50000000000L);
        Long sum = pool.invoke(tast);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时"+ Duration.between(start,end).toMillis());
        long en = System.currentTimeMillis();
        System.out.println("耗时"+(en-st)*1.0/1000);
    }

    @Test
    public void test1(){
        Instant start = Instant.now();

        long sum = 0L;

        for (long i = 0L; i <= 50000000000L; i++) {
            sum += i;
        }

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//35-3142-15704
    }

    //java8 新特性
    @Test
    public void test2(){
        Instant start = Instant.now();

        Long sum = LongStream.rangeClosed(0L, 50000000000L)
                .parallel()
                .reduce(0L, Long::sum);

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//1536-8118
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long>{
    public static final long serialVersionUID = 1;
    private long start;
    private long end;
    private static final long THURSHOLD = 10000L;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length<=THURSHOLD){
            long sum = 0L;
            for(long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else {
            long middle = (start+end)/2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork();
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1,end);
            right.fork();
            return left.join()+right.join();

        }
    }
}
