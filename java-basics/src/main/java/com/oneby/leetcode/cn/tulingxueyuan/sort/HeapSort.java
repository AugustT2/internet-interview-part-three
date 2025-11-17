package com.oneby.leetcode.cn.tulingxueyuan.sort;

/**
 * @author Mark老师
 * 类说明：堆排序
 */
public class HeapSort {
    //声明全局变量，用于记录数组array的长度；
    private static int len;

     /* 交换数组内两个元素*/
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] sortArray(int[] nums) {
        len = nums.length;
        if (len < 1) return nums;
        /*1.构建一个最大堆*/
        buildMaxHeap(nums);
        /*2.循环将堆首位（最大值）与未排序数据末位交换，然后重新调整为最大堆*/
        while (len > 0) {
            swap(nums, 0, len - 1);
            len--;
            adjustHeap(nums, 0);
            PrintArray.print(nums);
            System.out.println("--------------------");
        }
        return nums;
    }

    /**
     * 建立最大堆
     */
    public static void buildMaxHeap(int[] array) {
        /*从最后一个非叶子节点开始向上构造最大堆*/
        for (int i = (len/2-1); i >= 0; i--) {
            adjustHeap(array, i);
        }
        System.out.println("构造完成最大堆");
        PrintArray.print(array);
        System.out.println("============================================");
    }

    /**
     * 调整使之成为最大堆
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        int left = 2*i+1;
        int right = 2*(i+1);
        /*如果有左子树，且左子树大于父节点，则将最大指针指向左子树*/
        if (left < len && array[left] > array[maxIndex])
            maxIndex = left;
        /*如果有右子树，且右子树大于父节点且大于左子树，则将最大指针指向右子树*/
        if (right < len && array[right] > array[maxIndex]&&array[right]>array[left])
            maxIndex = right;
        /*如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。*/
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            PrintArray.print(array);
            adjustHeap(array, maxIndex);
        }
    }



    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = new HeapSort().sortArray(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
