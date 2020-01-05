package com.chang.java9Test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @User: chang
 */
public class DiamondOperatorTest {
    public void diamondOperator(){
        //创建一个继承于HashSet的匿名子类的对象
        Set<String> set = new HashSet<>(){};//编译通过
        set.add("MM");
        set.add("JJ");
        set.add("GG");
        set.add("DD");
        for(String s : set){
            System.out.println(s);
        }
    }

    @Test
    public void testDiamondOperator(){
        diamondOperator();
    }
}
