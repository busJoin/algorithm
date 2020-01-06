package com.chang;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: chang
 */
public class EpsilonTest {
    // 执行: -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
    public static void main(String[] args) {
        List<Garbage> list = new ArrayList<>();
        boolean flag = true;
        int count = 0;
        while (flag) {
            list.add(new Garbage(count));
            if (count++ == 500) {
                list.clear();
            }
        }
    }
}

class Garbage {

    private double d1 = 1;
    private double d2 = 2;

    public Garbage(double d1){
        this.d1 = d1;
    }

    // 这个方法是GC在清除本对象时, 会调用一次
    @Override
    public void finalize() {
        System.out.println(this + " collecting"+this.d1);
    }
}