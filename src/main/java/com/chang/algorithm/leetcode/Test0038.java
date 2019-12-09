package com.chang.algorithm.leetcode;

import org.junit.Test;

public class Test0038 {
    @Test
    public void test(){
        String s = countAndSay(5);
        System.out.println(s);
    }
    public String countAndSay(int n) {
        String s = 1+"";
        if (n==1){
            return s;
        }
        for (int i=2;i<=n;i++){
            s = say(s);
        }
        return s;
    }

    public String say(String s){
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<s.length();i++){
            if (i+1<s.length()&&s.charAt(i+1)==s.charAt(i)){
                count++;
            }else {
                sb.append(count+""+s.substring(i,i+1));
                count=1;
            }
        }
        return sb.toString();
    }
}
