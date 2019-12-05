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
//        radixSort(arr);
//        countSort(arr);
        heapSort(arr);
        print(arr);
    }

    /**
     * 堆排序(大顶堆从小到大)
     * @param arr
     */
    public static void heapSort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从最后一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 计数排序，只能用于区间不大的,非负数
     * @param arr
     */
    public static void countSort(int[] arr){
        int n = arr.length;
        if (n<=1){
            return;
        }
        int max = arr[0];
        for (int i=0;i<n;i++){
            if (max<arr[i]){
                max = arr[i];
            }
        }
        int[] c = new int[max+1];
        for (int i=0;i<n;i++){
            c[arr[i]]++;
        }
        //后面的计数是前面所有的总数+本组，可当初该数在排序数组的下标终点
        for (int i=1;i<=max;i++){
            c[i]=c[i]+c[i-1];
        }
        int[] r = new int[n];
        for (int i=n-1;i>=0;i--){
            int index = c[arr[i]]-1;
            r[index] = arr[i];
            c[arr[i]]--;
        }
        for (int i=0;i<n;i++){
            arr[i]=r[i];
        }
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
