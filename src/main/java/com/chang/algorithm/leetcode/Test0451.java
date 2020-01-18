package com.chang.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。(区分大小写)
 * 65-90 A-Z   97-122 a-z
 * @User: chang
 */
public class Test0451 {

    public String frequencySort(String s) {
        int[] list = new int[128];
        for (int i=0;i<s.length();i++){
            list[s.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        //找到最大值
        int max = Integer.MAX_VALUE;
        int[] copy = Arrays.copyOf(list, 128);
        Arrays.sort(copy);
        int i=127;
        while (max>0){
            if (copy[i]==0){
                break;
            }
            if (copy[i]==copy[i-1]){
                i--;
                continue;
            }
            //找到当前小于max的最大值
            max=copy[i];
            //把值等于max的都添加进去A-Z
            for (int j=0;j<128;j++){
                if (list[j]==max){
                    //添加当前字符串
                    for (int k=0;k<max;k++){
                        sb.append((char) j);
                    }
                }
            }
            i--;
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(frequencySort("tree"));
    }
}
