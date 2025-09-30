package com.oneby.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        moveZeroes(array);
    }

    /**
     * 283 我们用一个指针k记录当前待插入的位置，初始时k=0;然后我们遍历数组nums,每次遇到一个非零数，就将其与num[k]交换，同时将k的值加
     * 1。这样我们就可以保证nums的前k个元素都是非零的，且它们的相对顺序与原数组一致
     * 当数组元素里面是非0是里面的交换啥也没干（因为i和k的值是一样的），当遇到0是，i增加了，k不动，k落后了i一个数，下一次非0时nums[k]就是0，实现交换就成了0去后面了
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
