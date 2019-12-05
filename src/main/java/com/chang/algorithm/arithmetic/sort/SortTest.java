package com.chang.algorithm.arithmetic.sort;

/**
 * @author changhao
 * @date 12/4/19 7:07 下午
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {1, 0, 4, 5, 9, 10, 8};
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        quickSort(arr,0,arr.length-1);
        int[] temp = new int[arr.length];
//        mergeSort(arr,0,arr.length-1,temp);
        radixSort(arr);
        print(arr);
    }

    /**
     * 基数排序(不排负数，稳定)
     */
    public static void radixSort(int[] arr) {
        //找出最大数是几位
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int o = 0, n = 1; o < maxLength; o++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
            }
            int index = 0;
            for (int k = 0; k < 10; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                    bucketElementCounts[k] = 0;
                }
            }
        }

    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //分
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            //合
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并排序合并的方法
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
            while (i <= mid) {
                temp[t++] = arr[i++];
            }
            while (j <= right) {
                temp[t++] = arr[j++];
            }
            for (int a = 0; a < t; a++) {
                arr[left + a] = temp[a];
            }
        }
    }

    /**
     * 快排
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        //交换法
        /*int temp = 0;
        for (int gap=arr.length/2;gap>0;gap/=2){
            //gap是分了几组
            for (int i=gap;i<arr.length;i++){
                for (int j=i-gap;j>=0;j-=gap){
                    if (arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }*/
        //位移法
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //需要插入的值还未赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }

        }
    }

    /**
     * 选择排序(每次把最小的拎到前面)
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }
}
