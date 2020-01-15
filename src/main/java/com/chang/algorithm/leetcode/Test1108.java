package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * @User: chang
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class Test1108 {
    public String defangIPaddr(String address) {
        //效率太低
//        return address.replace(".","[.]");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<address.length();i++){
            if (address.charAt(i)=='.'){
                sb.append("[.]");
            }else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = defangIPaddr("1.1.1.1");
        System.out.println(s);
    }
}
