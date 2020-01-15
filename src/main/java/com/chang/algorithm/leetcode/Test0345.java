package com.chang.algorithm.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @User: chang
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class Test0345 {
    public String reverseVowels(String s) {
        char[] r = {'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> list = new HashSet<>();
        for (int i = 0; i < r.length; i++) {
            list.add(r[i]);
        }
        int i=0,j=s.length()-1;
        char[] chars = s.toCharArray();
        while (i<j){
            while (!list.contains(chars[i])&&i<s.length()){
                i++;
            }
            while (!list.contains(chars[j])&&j>0){
                j--;
            }
            if (i<j){
                char temp = chars[i];
                chars[i++]=chars[j];
                chars[j--]=temp;
            }
        }
        return new String(chars);
    }
    @Test
    public void test(){
        String s = reverseVowels("Ui");
        System.out.println(s);
    }
}
