package com.chang.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test1078 {
    @Test
    public void test(){
        String s1 = "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa";
        String s2 = "kcyxdfnoa";
        String s3 = "jkypmsxd";
        String[] ocurrences = findOcurrences(s1, s2, s3);
        System.out.println(Arrays.toString(ocurrences));
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> set = new ArrayList<>();
        for (int i=1;i<strs.length-1;i++){
            if (second.equals(strs[i])&&first.equals(strs[i-1])){
                set.add(strs[i+1]);
            }
        }
        if (set.size()>0){
            String[] result = new String[set.size()];
            int i=0;
            for (String s:set){
                result[i++] = s;
            }
            return result;
        }else {
            return new String[]{};
        }

    }
}
