package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0028 {
    @Test
    public void test(){
        "d".indexOf("");
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }
        int i =0;
        int j =0;
        while (i<haystack.length()){
            if (haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                //若越界，说明找到了
                if (j>=needle.length()){
                    return i-j;
                }
            }else {
                //从开始的后以为开始
                i=i-j+1;
                j=0;
            }
        }
        return -1;
    }
}
