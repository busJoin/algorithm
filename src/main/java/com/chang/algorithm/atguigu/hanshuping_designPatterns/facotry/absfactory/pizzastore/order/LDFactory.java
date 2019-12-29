package com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.order;

import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.pizza.Pizza;
import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.pizza.LDCheesePizza;
import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.pizza.LDPepperPizza;

public class LDFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }

}