package com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.factorymethod.pizzastore.order;

import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.chang.algorithm.atguigu.hanshuping_designPatterns.facotry.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        // TODO Auto-generated method stub
        return pizza;
    }

}
