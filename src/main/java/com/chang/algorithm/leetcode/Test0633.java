package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0633 {
    @Test
    public void test() {
        boolean b = judgeSquareSum1(81);
        System.out.println(b);
    }

    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            int temp = i * i + j * j;
            if (temp > c) {
                j--;
            } else if (temp < c) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 别人的最优
     * 费马平方和定理
     * 费马平方和定理告诉我们：
     *
     * 一个非负整数 cc 能够表示为两个整数的平方和，当且仅当 cc 的所有形如 4k+34k+3 的质因子的幂次均为偶数。
     *
     */
    public boolean judgeSquareSum1(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
