package com.chang.algorithm.hanshuping_designPatterns.adapter.interfaceadapter;

/**
 * 接口适配模式(实现部分接口)
 */
public class Client {
    public static void main(String[] args) {

        AbsAdapter absAdapter = new AbsAdapter() {
            //只需要去覆盖我们 需要使用 接口方法
            @Override
            public void m1() {
                // TODO Auto-generated method stub
                System.out.println("使用了m1的方法");
            }
        };

        absAdapter.m1();
    }
}
