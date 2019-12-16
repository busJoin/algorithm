package com.chang.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test0455 {
    @Test
    public void test(){
        int[] arr = {1,2,3};
        int[] arr2 = {2,2};
        int contentChildren = findContentChildren(arr, arr2);
        System.out.println(contentChildren);
    }
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while (i<g.length&&j<s.length){
            if (g[i]<=s[j]){
                i++;
                j++;
                count++;
            }else {
                j++;
            }
        }
        return count;
    }
}
