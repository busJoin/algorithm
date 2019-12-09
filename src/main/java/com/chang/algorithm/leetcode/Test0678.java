package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0678 {

    @Test
    public void test(){
        //暂未完成
        boolean b = checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*");
        System.out.println(b);
    }

    public static boolean checkValidString(String s) {
        if (!s.matches("[()*]*")){
            return false;
        }
        int leftCount = 0;
        int rightCount = 0;
        int wailCount = 0;
        //正过来走一遍
        for (int i=0;i<s.length();i++){
            String cur = s.substring(i,i+1);
            if ("(".equals(cur)){
                leftCount++;
            }
            if (")".equals(cur)){
                rightCount++;
                if (leftCount+wailCount<rightCount){
                    return false;
                }
            }
            if ("*".equals(cur)){
                wailCount++;
            }
        }
        int wait = Math.abs(leftCount - rightCount);
        if (wait>wailCount){
            return false;
        }

        leftCount = 0;
        rightCount = 0;
        wailCount = 0;
        //正过来走一遍
        for (int i=s.length()-1;i>=0;i--){
            String cur = s.substring(i,i+1);
            if ("(".equals(cur)){
                leftCount++;
            }
            if (")".equals(cur)){
                rightCount++;
            }
            if ("*".equals(cur)){
                wailCount++;
            }
        }
        wait = Math.abs(leftCount - rightCount);
        if (wait>wailCount){
            return false;
        }
        return true;
    }
}
