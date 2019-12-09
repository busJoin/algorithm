package com.chang.algorithm.leetcode;

import org.junit.Test;

public class Test0058 {

    @Test
    public void test(){
        int i = lengthOfLastWord("a b");
        System.out.println(i);
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.trim().length()==0){
            return 0;
        }
        int count = 0;
        for (int i=s.length()-1;i>=0;i--){
            if (' '==s.charAt(i)){
                return count;
            }else {
                count++;
            }
        }
        return count;
    }
}
