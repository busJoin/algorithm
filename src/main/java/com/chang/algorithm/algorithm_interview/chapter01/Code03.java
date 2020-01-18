package com.chang.algorithm.algorithm_interview.chapter01;

/**
 * 如何计算两个单链表所代表的数之和
 * 3-1-5
 * 5-9-2
 * 8-0-8
 *
 * @User: chang
 */
public class Code03 {
    public static void main(String[] args) {
        int i = 1;
        LNode head1 = new LNode();
        LNode head2 = new LNode();
        LNode tmp = null;
        LNode cur = head1;
        LNode addResult = null;
        //第一个链表
        for (; i < 7; i++) {
            tmp = new LNode();
            tmp.data = i + 2;
            cur.next = tmp;
            cur = tmp;
        }
        cur = head2;
        for (i = 9; i > 4; i--) {
            tmp = new LNode();
            tmp.data = i;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.print("第一个数");
        for (cur = head1.next; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
        System.out.print("第二个数");
        for (cur = head2.next; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
        head1 = add1(head1, head2);
        System.out.print("和的数字");
        for (cur = head1.next; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
    }

    /**
     * 链表相加法
     */
    public static LNode add1(LNode h1, LNode h2){
        if (h1==null|| h1.next==null){
            return h2;
        }
        if (h2==null|| h2.next==null){
            return h1;
        }
        //保存进位
        int c=0;
        int sum=0;
        LNode p1= h1.next;
        LNode p2 = h2.next;
        LNode tmp = null;
        LNode resultHead = new LNode();
        LNode p = resultHead;
        while (p1!=null&&p2!=null){
            tmp = new LNode();
            sum=p1.data+p2.data+c;
            tmp.data=sum%10;
            c=sum/10;
            p.next=tmp;
            p=tmp;
            p1=p1.next;
            p2=p2.next;
        }
        if (p1==null){
            while (p2!=null){
                tmp = new LNode();
                sum=p2.data+c;
                tmp.data=sum%10;
                c=sum/10;
                p.next=tmp;
                p=tmp;
                p2=p2.next;
            }
        }else if (p2==null){
            while (p1!=null){
                tmp = new LNode();
                sum=p1.data+c;
                tmp.data=sum%10;
                c=sum/10;
                p.next=tmp;
                p=tmp;
                p1=p1.next;
            }
        }
        //如果还有进位
        if (c==1){
            tmp = new LNode();
            tmp.data=1;
            p.next=tmp;
        }
        return resultHead;
    }

    /**
     * 整数相加法
     */
    public static LNode add(LNode l1, LNode l2) {
        int n = 1;
        LNode tmp = l1.next;
        int num1 = 0;
        int num2 = 0;
        while (tmp != null) {
            num1+=tmp.data*n;
            n*=10;
            tmp=tmp.next;
        }
        tmp=l2.next;
        n=1;
        while (tmp!=null){
            num2+=tmp.data*n;
            n*=10;
            tmp=tmp.next;
        }
        num1=num2+num1;
        LNode newNode = new LNode();
        LNode pre = newNode;
        while (num1>0){
            int a=num1%10;
            tmp=new LNode();
            tmp.data=a;
            num1/=10;
            pre.next=tmp;
            pre=pre.next;
        }
        return newNode;
    }
}
