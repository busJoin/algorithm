package com.chang.java9;


import com.chang.java9Test.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @User: chang
 */
public class ModuleTest {
    public static final Logger LOGGER = Logger.getLogger("java9test");
    public static void main(String[] args){
        Person p = new Person("马云",40);
        System.out.println(p);
        LOGGER.info("aaa");
        ModuleTest test = new ModuleTest();
        test.flattenStrings(new ArrayList<>());
    }

    private List flattenStrings(List<String>...lists){
        Set<Object> set = new HashSet<>(){};
        for (List<String> list : lists) {
            set.add(list);
        }
        return new ArrayList<>(set);
    }

    @Test
    public void test1(){
        System.out.println("hello");
    }
}
