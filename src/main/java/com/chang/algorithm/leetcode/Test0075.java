package com.chang.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @User: chang
 */
public class Test0075 {

    public void sortColors(int[] nums) {
        //当前进行的位置
        int i=0;
        //最后一个2的位置
        int j=nums.length-1;
        //遍历的下一个塞0的位置
        int p0 =0;
        while (i<=j){
            //查到最后一个不是2的数，确保末尾都是2
            //只有一个2，如果j不大于等于1会报错
            while (j>=1&&nums[j]==2){
                j--;
            }
            //如果当前位置是2
            if (nums[i]==2){
                swap(nums,i,j--);
            }else if (nums[i]==0){
                swap(nums,i++,p0++);
            }else {
                i++;
            }
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    @Test
    public void test(){
        int[] nums = {2};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
