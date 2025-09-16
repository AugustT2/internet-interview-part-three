package com.oneby.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 26. 删除有序数组中的重复项
 * 这里面是有序的，已经排好队了，只要不与前一个相同就加入新的数组
 */
public class RemoveArrayDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int x : nums) {
            if (k == 0 || x != nums[k - 1]) {
                nums[k++] = x;
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
        return k;
    }
}
