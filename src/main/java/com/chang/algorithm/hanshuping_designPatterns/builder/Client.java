package com.chang.algorithm.hanshuping_designPatterns.builder;

public class Client {
    /**
     * 产品创建过程封装在一起，耦合性增强了
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }
}
