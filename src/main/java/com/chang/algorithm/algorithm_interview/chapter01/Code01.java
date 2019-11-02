package com.chang.algorithm.algorithm_interview.chapter01;

import com.alibaba.fastjson.JSON;

/**
 * 如何实现链表的逆序
 */
public class Code01 {
    public static void main(String[] args) {
        LNode head = new LNode();
        init(head);
        System.out.println("初始化数据");
        print(head);
        Reverse(head);
        System.out.println("反转后数据");
        System.out.println(JSON.toJSONString(head));
        print(head);
    }

    /**
     * 初始化数据
     * @param head
     */
    private static void init(LNode head){
        LNode cur = new LNode();
        head.next=cur;
        for (int i=0;i<9;i++){
            cur.data=i;
            cur.next = new LNode();
            cur = cur.next;
        }
    }

    /**
     * 打印数据
     */
    private static void print(LNode head){
        LNode cur = head.next;
        while (cur.next!=null){
            System.out.print(cur.getData()+",");
            cur=cur.next;
        }
        System.out.println();
    }

    /**
     * 就地逆序
     * O(N)
     */
    private static void Reverse(LNode head){
        //空链表
        if (head==null || head.next==null){
            return;
        }
        LNode pre = null;
        LNode cur = null;
        LNode next = null;
        //链表首结点变成尾结点
        cur = head.next;
        pre=cur.next;
        cur.next=null;
        //遍历接下来的结点
        while (pre.next!=null){
            pre = pre.next;
            cur.next=next;
            next=cur;
            cur = cur.next;
            cur=pre;
        }
        //结点最后一个结点指向倒数第二个
        cur.next=next;
        head.next=cur;
    }
}
