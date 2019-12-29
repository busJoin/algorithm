package com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.order;

public class PizzaStore {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //new OrderPizza(new BJFactory());
        new OrderPizza(new LDFactory());
    }
}
