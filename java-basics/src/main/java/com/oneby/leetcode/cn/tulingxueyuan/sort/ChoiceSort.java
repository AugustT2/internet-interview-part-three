package com.oneby.leetcode.cn.tulingxueyuan.sort;

/**
 * @author Mark老师
 * 类说明：简单选择排序（升序）
 */
public class ChoiceSort {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0)
            return nums;
        for (int i = 0; i < nums.length; i++) {
            int minIndex=i;/*最小数的下标，每个循环开始总是假设第一个数最小*/
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) /*找到最小的数*/
                    minIndex = j; /*将最小数的索引保存*/
            }
            System.out.println("最小数为："+nums[minIndex]);
            /*交换最小数和i当前所指的元素*/
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
            PrintArray.print(nums);
            System.out.println("---------------");
        }
        return nums;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = new ChoiceSort().sortArray(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
