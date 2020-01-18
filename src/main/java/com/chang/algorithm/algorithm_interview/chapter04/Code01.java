package com.chang.algorithm.algorithm_interview.chapter04;

import java.util.Hashtable;

/**
 * 如何找出数组中唯一的重复元素
 * 1-1000放在1001个元素的数组中
 * @User: chang
 */
public class Code01 {
    public static void main(String[] args) {
        int[] array = {1,4,3,2,5,4};
        System.out.println(findDup2(array));
    }

    /**
     * 异或大法
     * @param array
     * @return
     */
    public static int findDup2(int[] array){
        if (null==array){
            return -1;
        }
        int len =array.length;
        int result =0;
        int i;
        for (i = 0;i<len;i++){
            result^=array[i];
        }
        for (i=1;i<len;i++){
            result^=i;
        }
        return result;
    }

    /**
     * 累加求和
     * @param array
     * @return
     */
    public static int findDup1(int[] array){
        if (null==array){
            return -1;
        }
        int sum = 0;
        int len = array.length;
        for (int i=0;i<len;i++){
            sum+=array[i];
        }
        return sum-(len-1)*len/2;
    }

    /**
     * 空间换时间
     * @param array
     * @return
     */
    public static int findDup(int[] array){
        if (null==array){
            return -1;
        }
        int len = array.length;
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        int i;
        for (i=0;i<len-1;i++){
            hashtable.put(i,0);
        }
        for (i=0;i<len;i++){
            if (hashtable.get(array[i]-1)==0){
                hashtable.put(array[i]-1,array[i]-1);
            }else {
                return array[i];
            }
        }
        return -1;
    }
}
