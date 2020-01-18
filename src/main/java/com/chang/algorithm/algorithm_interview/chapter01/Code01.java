package com.chang.algorithm.algorithm_interview.chapter01;

/**
 * 如何实现链表的逆序（带头结点的单链表）
 * head-1-2-3
 * head-3-2-1
 */
public class Code01 {
    public static void main(String[] args) {
        //链表头结点
        LNode head = new LNode();
        head.next=null;
        LNode tmp =null;
        LNode cur=head;
        //构造单链表
        for (int i = 0; i < 8; i++) {
            tmp = new LNode();
            tmp.data=i;
            cur.next=tmp;
            cur=tmp;
        }
        System.out.print("逆序前");
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
        Reverse2(head);
        System.out.println();
        System.out.print("逆序后");
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
    }

    /**
     * 插入法(时间复杂度O(N))
     */
    public static void Reverse2(LNode head){
        if (head==null||head.next==null){
            return;
        }
        LNode cur =null;
        LNode next = null;
        cur=head.next.next;
        //设置链表第一个结点为尾结点
        head.next.next=null;
        //把遍历到结点插入到头结点的后面
        while (cur!=null){
            next=cur.next;
            cur.next=head.next;
            head.next=cur;
            cur=next;
        }
    }


    /**
     * 递归法（时间复杂度O(N),性能比原地逆序会下降）
     * 对带头结点单链表进行逆序
     */
    public static void Reverse1(LNode head){
        if (head==null){
            return;
        }
        //获取链表第一个结点
        LNode first = head.next;
        //对链表进行逆序
        LNode newhead = RecursiveReverse(first);
        //头结点指向逆序后的第一个结点
        head.next=newhead;
    }

    /**
     * 对不带头结点的单链表进行逆序
     * @param head
     * @return
     */
    public static LNode RecursiveReverse(LNode head){
        if (head==null||head.next==null){
            return head;
        }else {
            //反转后面的结点
            LNode newhead = RecursiveReverse(head.next);
            //把当前遍历结点加到后面结点链表的尾部
            head.next.next=head;
            //主要是最后两个元素会循环
            head.next=null;
            return newhead;
        }

    }

    /**
     * 就地逆序(时间复杂度O(N),空间复杂度O(1))
     * @param head 单链表的头结点
     */
    public static void Reverse(LNode head){
        //剔除不需要逆序的情况
        if (head==null||head.next==null){
            return;
        }
        //前驱结点(cur的next对象)
        LNode pre =null;
        //当前结点
        LNode cur =null;
        //后继结点(原链表下一个对象)
        LNode next =null;
        //把链表首结点变为尾结点
        cur=head.next;
        next=cur.next;
        cur.next=null;
        pre=cur;
        cur=next;
        //使当前遍历到的结点cur指向其前驱结点
        while (cur.next!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        //结点最后一结指向倒数第二个结点
        cur.next=pre;
        //链表的头结点指向原链表的尾结点
        head.next=cur;
    }

}
