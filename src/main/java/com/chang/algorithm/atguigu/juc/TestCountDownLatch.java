package com.chang.algorithm.atguigu.juc;

import java.util.concurrent.CountDownLatch;

/*
 * CountDownLatch ：闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        LatchDemo ld = new LatchDemo(latch);
        long start = System.currentTimeMillis();
        //启动的线程数要和countDownLatch一样多，latch多了等不到结果，少了提前得到结果
        for (int i=0;i<1;i++){
            new Thread(ld).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为"+(end-start));

    }
}

class LatchDemo implements Runnable{
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i=0;i<50000;i++){
                if (i%2==0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }finally {
            latch.countDown();
        }
    }
}