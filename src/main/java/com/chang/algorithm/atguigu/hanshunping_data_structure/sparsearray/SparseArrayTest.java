package com.chang.algorithm.atguigu.hanshunping_data_structure.sparsearray;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 稀疏数组
 * <p>
 * 应用实例
 * 使用稀疏数组，来保留类似前面的二维数组(棋盘、地图等等)
 * 把稀疏数组存盘，并且可以从新恢复原来的二维数组数
 * 整体思路分析
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        //0 表示没有棋子，1表示黑子，2表示白字
        int[][] arr1 = new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        arr1[4][6] = 2;
        System.out.println("原数组是");
        print(arr1);
        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非0数据的个数
        int[][] sparseArr = getSparseArray(arr1);

        // 输出稀疏数组的形式
        System.out.println("得到稀疏数组为~~~~");
        print(sparseArr);
        save(sparseArr);


        //将稀疏数组 --》 恢复成 原始的二维数组
		/*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] sparseArr1 = read();
        int[][] arr2 = new int[sparseArr1[0][0]][sparseArr1[0][1]];
        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i < sparseArr1.length; i++) {
            arr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }
        // 输出恢复后的二维数组
        System.out.println("输出恢复后的二维数组");
        print(arr2);
    }

    public static void print(int[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] getSparseArray(int[][] arr1) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = arr1.length;
        sparseArr[0][1] = arr1[0].length;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到 sparseArr中
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr1[i][j];
                }
            }
        }
        return sparseArr;
    }

    //IO
    public static void save(int[][] arr1) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./map.data"));
            objectOutputStream.writeObject(arr1);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[][] read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream("./map.data")));
            int[][] arr = (int[][])objectInputStream.readObject();
            return arr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new int[1][1];
    }


}
