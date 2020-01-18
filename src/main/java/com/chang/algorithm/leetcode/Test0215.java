package com.chang.algorithm.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @User: chang
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class Test0215 {
    @Test
    public void test() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int i=0;
        i = findKthLargest(nums, 4);
        System.out.println(i);
    }

    /**
     * 抄的方法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // output
        return heap.poll();
    }

}
