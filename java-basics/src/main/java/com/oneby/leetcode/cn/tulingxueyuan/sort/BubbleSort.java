package com.oneby.leetcode.cn.tulingxueyuan.sort;

/**
 * @author Mark老师
 * 类说明：冒泡算法（升序）
 */
public class BubbleSort {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0)
            return nums;
        /*循环数组长度的次数*/
        for (int i = 0; i < nums.length; i++){

            /*从第0个元素开始，依次和后面的元素进行比较
             * j < array.length - 1 - i表示第[array.length - 1 - i]
             * 个元素已经冒泡到了合适的位置，无需进行比较，可以减少比较次数*/
            for (int j = 0; j < nums.length - 1 - i; j++){
                /*如果第j个元素比后面的第j+1元素大，交换两者的位置*/
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
                PrintArray.print(nums);
            }
            System.out.println("---------------");
            //PrintArray.print(array);
        }

        return nums;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = new BubbleSort().sortArray(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
