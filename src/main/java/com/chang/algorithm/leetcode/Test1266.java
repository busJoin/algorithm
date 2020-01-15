package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * @User: chang
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 *
 * 你可以按照下面的规则在平面上移动：
 *
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 */
public class Test1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length==1){
            return 0;
        }
        int sum=0;
        for (int i=1;i<points.length;i++){
            int x=Math.abs(points[i-1][0]-points[i][0]);
            int y=Math.abs(points[i-1][1]-points[i][1]);
            sum+=Math.max(x,y);
        }
        return sum;
    }

    @Test
    public void test(){
        int[][] points = new int[3][2];
        points[0]= new int[]{1, 1};
        points[1]= new int[]{3, 4};
        points[2]= new int[]{-1, 0};

        int i = minTimeToVisitAllPoints(points);
        System.out.println(i);
    }
}
