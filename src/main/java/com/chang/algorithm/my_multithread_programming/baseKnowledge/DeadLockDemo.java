package com.chang.algorithm.my_multithread_programming.baseKnowledge;

/**
 * @User: chang
 */
public class DeadLockDemo {
    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_a) {
                    System.out.println(Thread.currentThread().getName()+"get resource a");
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_b) {
                            System.out.println(Thread.currentThread().getName()+"get resource b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_b) {
                    System.out.println(Thread.currentThread().getName()+"get resource b");
                    synchronized (resource_a) {
                        System.out.println(Thread.currentThread().getName()+"get resource a");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();

    }
}
