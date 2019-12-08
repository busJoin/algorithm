package com.chang.algorithm.arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

public class SearchSort {
    @Test
    public void test(){
        int[] arr = {1,8,10,89,100,123};
//        int index = seqSearch(arr,9);
//        int index = binarySearch(arr,0,arr.length-1,11);
//        int index = insertValueSearch(arr,0,arr.length-1,10);
        int index = fibSearch(arr,11);
        System.out.println(index);
    }

    /**
     * 斐波那契查找算法
     * @param a
     * @param key
     * @return
     */
    public static int fibSearch(int[] a,int key){
        int low  = 0;
        int high = a.length-1;
        //斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int f[] = fib();
        //获取斐波那契分割值下标
        while (high>f[k]-1){
            k++;
        }
        //原数组长度可能不到f[k]，加长数组(末尾补上最大值)
        int[] temp = Arrays.copyOf(a,f[k]);
        for (int i=high+1;i<temp.length;i++){
            temp[i]=temp[high];
        }
        while (low<=high){
            mid = low+f[k-1]-1;
            if (key<temp[mid]){
                high=mid-1;
                k--;
            }else if (key>temp[mid]){
                low=mid+1;
                k-=2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

    private static int[] fib(){
        int[] fib = new int[20];
        fib[0]=1;
        fib[1]=1;
        for (int i=2;i<20;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib;
    }

    /**
     * 插值查找（适用于分布均匀）
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        if (left>right||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }
        int mid = left + (right - left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal = arr[mid];
        if (findVal>midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            //如果是有相同的值，可以向左右遍历
            return mid;
        }
    }

    /**
     * 二分查找法
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal>midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            //如果是有相同的值，可以向左右遍历
            return mid;
        }
    }

    /**
     * 线性查找
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
