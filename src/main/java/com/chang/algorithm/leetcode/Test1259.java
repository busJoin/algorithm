package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * @User: chang
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 */
public class Test1259 {
    public int findNumbers(int[] nums) {
        int result = 0;

        for (int n:nums) {
            int i=0;
            while (n>0){
                n=n/10;
                i++;
            }
            if (i%2==0){
                result++;
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums = {12,345,2,6,7896};
        int numbers = findNumbers(nums);
        System.out.println(numbers);
    }
}
