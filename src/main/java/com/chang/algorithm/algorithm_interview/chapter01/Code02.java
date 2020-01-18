package com.chang.algorithm.algorithm_interview.chapter01;

import java.util.HashSet;

/**
 * 如何从无序链表中移除重复项
 * 1-3-1-5-5-7
 * 1-3-5-7
 * @User: chang
 */
public class Code02 {
    public static void main(String[] args) {
        int i=1;
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;
        for (;i<7;i++){
            tmp = new LNode();
            if (i%2==0){
                tmp.data=i+1;
            }else if (i%3==0){
                tmp.data=i-2;
            }else {
                tmp.data=i;
            }
            tmp.next=null;
            cur.next=tmp;
            cur=tmp;
        }
        System.out.print("删除重复结点前");
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
        System.out.println();
        removeDup2(head);
        System.out.print("删除后");
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
    }

    /**
     * 空间换时间
     * @param head
     */
    public static void removeDup2(LNode head){
        if (head==null){
            return;
        }
        LNode tmp = head;
        HashSet<Integer> list = new HashSet<>();
        while (tmp.next!=null){
            if (list.contains(tmp.next.data)){
                tmp.next=tmp.next.next;
            }else {
                tmp=tmp.next;
                list.add(tmp.data.intValue());
            }
        }
    }


    /**
     * 递归方法
     * 时间复杂度 O(N^2)
     */
    public static void removeDup1(LNode head){
        if (head==null){
            return;
        }
        head.next=removeDupRecursion(head.next);
    }
    private static LNode removeDupRecursion(LNode head){
        if (head.next==null){
            return head;
        }
        LNode pointer;
        LNode cur = head;
        //删除以head.next为首的重复结点
        head.next=removeDupRecursion(head.next);
        pointer=head.next;
        while (pointer!=null){
            if (head.data.equals(pointer.data)){
                cur.next=pointer.next;
                break;
            }else {
                pointer = pointer.next;
                cur=cur.next;
            }
        }
        return head;
    }

    /**
     * 顺序删除(带头结点的删除)
     * 时间复杂度 O(N^2) 空间复杂度 O(1)
     */
    public static void removeDup(LNode head){
        if (head==null||head.next==null){
            return;
        }
        //外层循环，(从第一个开始扫描)
        LNode outCur = head.next;
        //内层循环,用于删除后面的
        LNode innerCur = null;
        //inner的前驱结点
        LNode innerPre=null;
        for (;outCur!=null;outCur=outCur.next){
            //删除outcur后面所有与outcur重复的结点
            for (innerCur=outCur.next,innerPre=outCur;innerCur!=null;){
                //找到重复的并删除
                if (innerCur.data.equals(outCur.data)){
                    innerPre.next=innerCur.next;
                    innerCur=innerCur.next;
                }else {
                    innerPre=innerCur;
                    innerCur=innerCur.next;
                }
            }
        }
    }
}
