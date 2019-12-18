package com.chang.algorithm.leetcode;

import org.junit.Test;
/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.LinkedList;
import java.util.Queue;

public class Test0225 {
    @Test
    public void test(){

    }
}

class MyStack {

    Queue<Integer> q1 ;
    Queue<Integer> q2 ;
    int top;


    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.size()<=1){
            return q1.remove();
        }
        while (q1.size()>2){
            q2.add(q1.remove());
        }
        q2.add(top = q1.remove());
        int temp = q1.remove();
        Queue<Integer> tempQueue = q1;
        q1 = q2;
        q2 = tempQueue;
        return temp;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size()==0;
    }
}