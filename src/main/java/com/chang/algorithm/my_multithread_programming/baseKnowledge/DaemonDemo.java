package com.chang.algorithm.my_multithread_programming.baseKnowledge;

/**
 * @User: chang
 */
public class DaemonDemo {
    public static void main(String[] args) {
        DaemonDemo dd = new DaemonDemo();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (dd){
                    System.out.println("具体对象");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (DaemonDemo.class){
                    System.out.println("静态");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();




        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("i am alive");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("finally block");
                    }
                }
            }
        });
        daemonThread.setDaemon(true);//设置了这个就只有一个主线程了，如果用户线程都接受了，守护进程也会默认结束
        daemonThread.start();
        //确保main线程结束前能给daemonThread能够分到时间片
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

