package com.oneby.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        moveZeroes(array);
    }

    /**
     * 283 我们用一个指针k记录当前待插入的位置，初始时k=0;然后我们遍历数组nums,每次遇到一个非零数，就将其与num[k]交换，同时将k的值加
     * 1。这样我们就可以保证nums的前k个元素都是非零的，且它们的相对顺序与原数组一致
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int k = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k++] = t;
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
    }

}
