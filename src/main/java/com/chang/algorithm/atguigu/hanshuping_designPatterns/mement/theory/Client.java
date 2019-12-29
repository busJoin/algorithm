package com.chang.algorithm.atguigu.hanshuping_designPatterns.mement.theory;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("状态1：攻击力100");

        //保存当前状态
        caretaker.add(originator.saveStateMemento());
        originator.setState("状态2：攻击力90");
        caretaker.add(originator.saveStateMemento());
        originator.setState(" 状态#3 攻击力 50 ");
        caretaker.add(originator.saveStateMemento());

        System.out.println("当前的状态是 =" + originator.getState());
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("恢复到状态1 , 当前的状态是");
        System.out.println("当前的状态是 =" + originator.getState());
    }
}
