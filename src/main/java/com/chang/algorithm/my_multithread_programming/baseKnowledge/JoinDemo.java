package com.chang.algorithm.my_multithread_programming.baseKnowledge;

import java.time.Duration;
import java.time.Instant;

/**
 * @User: chang
 */
public class JoinDemo {
    public static void main(String[] args) {
        final Instant now = Instant.now();
        Thread previousThread = Thread.currentThread();
        for (int i = 1; i <= 10; i++) {
            Thread curThread = new JoinThread(previousThread,now);
            curThread.start();
            previousThread = curThread;
        }
        System.out.println("当前");
    }

    static class JoinThread extends Thread {
        private Thread thread;
        private Instant ins;

        public JoinThread(Thread thread,Instant ins) {
            this.thread = thread;
            this.ins = ins;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " terminated."+ Duration.between(ins,Instant.now()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
