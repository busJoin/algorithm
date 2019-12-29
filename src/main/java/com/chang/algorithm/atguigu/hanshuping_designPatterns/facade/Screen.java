package com.chang.algorithm.atguigu.hanshuping_designPatterns.facade;

/**
 * 屏幕
 */
public class Screen {
    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }
    public void up() {
        System.out.println(" Screen up ");
    }

    public void down() {
        System.out.println(" Screen down ");
    }
}
