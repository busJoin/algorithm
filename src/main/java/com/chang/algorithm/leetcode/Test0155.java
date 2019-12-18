package com.chang.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0155 {
    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());   // 2
        System.out.println(minStack.getMin());   // 1
        minStack.pop();
        System.out.println(minStack.getMin());      // 返回 1.
        System.out.println(minStack.top());   //返回 1.

    }
}

class MinStack {

    Stack<Integer> nums ;
    Stack<Integer> min;

    public MinStack() {
        nums = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        nums.push(x);
        if (min.size()==0){
            min.push(x);
        }else {
            if (x<min.peek()){
                min.push(x);
            }else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        if (nums.size()>0){
            nums.pop();
            min.pop();
        }
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return min.peek();
    }
}