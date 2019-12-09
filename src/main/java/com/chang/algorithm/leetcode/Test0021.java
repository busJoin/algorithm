package com.chang.algorithm.leetcode;

import lombok.Data;
import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0021 {
    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 使用递归来解决
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}

@Data
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
