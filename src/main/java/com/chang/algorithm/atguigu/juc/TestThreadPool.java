package com.chang.algorithm.atguigu.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外开销，提高了响应的速度。
 *
 * 二、线程池的体系结构：
 * 	java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 * 		|--**ExecutorService 子接口: 线程池的主要接口
 * 			|--ThreadPoolExecutor 线程池的实现类
 * 			|--ScheduledExecutorService 子接口：负责线程的调度
 * 				|--ScheduledThreadPoolExecutor ：继承 ThreadPoolExecutor， 实现 ScheduledExecutorService
 *
 * 三、工具类 : Executors
 * ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 * ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
 * ExecutorService newSingleThreadExecutor() : 创建单个线程池。线程池中只有一个线程
 *
 * ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务。
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 5;
                }
            });
            list.add(future);
        }
        pool.shutdown();
        list.forEach(e-> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        });



        //Runable
        /*
        for (int i=0;i<10;i++){
            pool.submit(new ThreadPoolDemo(i));
        }
        pool.shutdown();*/
    }
}

class ThreadPoolDemo implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        for (int a=0;a<1;a++){
            try {
                Thread.sleep(100);
            }catch (Exception e){}
            System.out.println(i);
        }
    }

    public ThreadPoolDemo(int a){
        this.i = a;
    }


}
