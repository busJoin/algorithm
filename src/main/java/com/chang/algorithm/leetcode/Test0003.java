package com.chang.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0003 {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int max = 0;
        int head = 0;
        for (int i =0 ;i<map.length;i++){
            map[i]=-1;
        }
        int i=0;
        while (i<s.length()){
            if (-1!=map[s.charAt(i)]){
                if (map[s.charAt(i)]<head){
                    map[s.charAt(i)]=-1;
                    continue;
                }
                max = max>i-head?max:i-head;
                //head后移一位
                head = map[s.charAt(i)]+1;
                map[s.charAt(i)]=i;
            }else {
                map[s.charAt(i)]=i;
            }
            i++;
        }
        max = max>i-head?max:i-head;
        return max;
    }

    //滑动窗口
    public int lengthOfLongestSubstring1(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,i=0,j=0;
        while (i<n&&j<n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //优化滑动窗口
    public int lengthOfLongestSubstring2(String s){
        int n = s.length(),ans = 0;
        Map<Character,Integer> map =  new HashMap<>();
        for (int j=0,i=0;j<n;j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
    //更加优化
    public int lengthOfLongestSubstring3(String s){
        int n=s.length(),ans =0;
        int[] index = new int[128];
        for (int j=0,i=0;j<n;j++){
            i = Math.max(index[s.charAt(j)],i);
            ans = Math.max(ans,j-i+1);
            index[s.charAt(j)]=j+1;
        }
        return ans;
    }

    @Test
    public void test(){
        int length = lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
        int length1 = lengthOfLongestSubstring1("abcabcbb");
        System.out.println(length1);
        int length2 = lengthOfLongestSubstring3("aaaa");
        System.out.println(length2);
    }
}
