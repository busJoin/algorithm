package com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.order;

import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.pizza.Pizza;
import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.pizza.BJCheesePizza;
import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.absfactory.pizzastore.pizza.BJPepperPizza;

//这是工厂子类
public class BJFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        // TODO Auto-generated method stub
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }

}
