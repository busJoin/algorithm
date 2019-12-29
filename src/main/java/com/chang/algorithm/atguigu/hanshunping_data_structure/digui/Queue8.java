package com.chang.algorithm.atguigu.hanshunping_data_structure.digui;

/**
 * 八皇后问题
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    int[] array = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法\n",count);
        System.out.printf("一共尝试%d次冲突判断",judgeCount);
    }

    /**
     * 放置第n个皇后
     * @param n
     */
    private void check(int n){
        //以及完成了
        if (n==max){
            print();
            return;
        }
        for (int i=0;i<max;i++){
            array[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        judgeCount++;
        for (int i=0;i<n;i++){
            //在同一列或者同一斜列,不符合条件
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }


}

