package com.chang.algorithm.atguigu.hanshuping_designPatterns.mement.theory;

public class Memento {

    private String state;

    //构造器
    public Memento(String state){
        super();
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
