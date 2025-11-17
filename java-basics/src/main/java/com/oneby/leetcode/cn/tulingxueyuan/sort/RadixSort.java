package com.oneby.leetcode.cn.tulingxueyuan.sort;

import java.util.ArrayList;

/**
 * @author Mark老师
 * 类说明：基数排序
 */
public class RadixSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2)
            return nums;
        /*找出最大数*/
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        /*先算出最大数的位数,它决定了我们要进行几轮排序*/
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        /*构建桶*/
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        /*按照从右往左的顺序，依次将每一位都当做一次关键字，然后按照该关键字对数组排序，
        每一轮排序都基于上轮排序后的结果*/
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            System.out.println("----第"+i+"轮排序-----");
            /*遍历原始数组，投入桶中*/
            for (int j = 0; j < nums.length; j++) {
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }
            /*看看桶中数据的分布*/
            for (int b = 0; b < bucketList.size(); b++) {
                System.out.print("第"+b+"个桶包含数据：");
                PrintArray.printObject(bucketList.get(b));
            }
            /*桶中的数据写回原始数组，清除桶，准备下一轮的排序*/
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    nums[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = new RadixSort().sortArray(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
