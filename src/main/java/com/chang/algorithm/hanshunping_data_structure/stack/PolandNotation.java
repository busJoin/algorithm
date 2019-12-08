package com.chang.algorithm.hanshunping_data_structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author changhao
 * @date 12/2/19 4:59 下午
 * 逆波兰表达式计算
 */
public class PolandNotation {
    public static void main(String[] args) {
        //76  4*5-8+60+8/2
        //后缀表达式，逆波兰表达式
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //中缀表达式
        String expression = "(4*5)-8+60+8/2";
        String suffixExpression = parseSuffixExpression(expression);
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList" + list);
        int res = calculate(list);
        System.out.println("计算结果是" + res);
    }


    /**
     * 根据中缀表达式获取后缀表达式
     * @param expression
     * @return
     */
    public static String parseSuffixExpression(String expression){
        List<String> ls = new ArrayList<>();
        for (int i = 0 ;i<expression.length();i++){
            ls.add(expression.substring(i,i+1));
        }
        //符号栈
        Stack<String> s1 = new Stack<>();
        //数子栈
        List<String> s2 = new ArrayList<>();
        String num = "";
        for (int i=0;i<ls.size();i++){
            String item = ls.get(i);
            if (item.matches("\\d+")){
                num+=item;
                if (i==ls.size()-1){
                    s2.add(num);
                    num = "";
                }
                continue;
            }else {
                if (num.length()>0){
                    s2.add(num);
                    num = "";
                }
            }

            if (item.equals("(")){
                s1.add(item);
            }else if (item.equals(")")){
                //遇到右括号的情况
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //遇到运算符的情况
                while (s1.size()!=0&&operation(s1.peek())>=operation(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size()>0){
            s2.add(s1.pop());
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<s2.size();i++){
            sb.append(s2.get(i)+" ");
        }
        return sb.toString();
    }

    private static int operation(String s){
        char oper = s.charAt(0);
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -2;
        }
    }

    /**
     *逆波兰表达式计算
     * @param ls
     * @return
     */
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            //使用正则匹配
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("操作符有误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 根据String获取对应的list
     */
    public static List<String> getListString(String suffixExpression) {
        String[] splits = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String str : splits) {
            list.add(str);
        }
        return list;
    }
}
