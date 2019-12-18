package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1189 {
    @Test
    public void test(){
        int nlaebolko = maxNumberOfBalloons("nlaebolko");
        System.out.println(nlaebolko);
    }

    public int maxNumberOfBalloons(String text) {
        int[] num = new int[5];//b a n l o
        for (int i=0;i<text.length();i++){
            int a = text.charAt(i);
            if ('b'==a){
                num[0]++;
            }else if('a'==a){
                num[1]++;
            }else if ('n'==a){
                num[2]++;
            }else if('l'==a){
                num[3]++;
            }else if('o'==a){
                num[4]++;
            }
        }
        int temp = Math.min(num[0],num[1]);
        int temp2 = Math.min(num[2],num[3]/2);
        return Math.min(num[4]/2,Math.min(temp,temp2));

    }
}
