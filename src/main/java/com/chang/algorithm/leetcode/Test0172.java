package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 */
public class Test0172 {
    @Test
    public void test(){
        int i = trailingZeroes(5);
        System.out.println(i);
    }

    //凡是有一个5就要加1，一个25加1+1，
    public int trailingZeroes(int n) {
        if(n<5&&n>-5){
            return 0;
        }
        return n/5+trailingZeroes(n/5);
    }
}
