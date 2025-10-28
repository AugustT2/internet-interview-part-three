package com.oneby.leetcode;

public class BinarySearch {
    /**
     * 二分查找算法
     * @param arr 已排序的数组
     * @param target 要查找的目标值
     * @return 目标值在数组中的索引，如果不存在则返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // 防止溢出，等同于(left + right)/2
            int mid = left + (right - left) / 2;
            // 找到目标值，返回索引
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // 目标值在右半部分
                left = mid + 1;
            } else {
                // 目标值在左半部分
                right = mid - 1;
            }
        }
        // 未找到目标值
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;

        int result = binarySearch(sortedArray, target);

        if (result == -1) {
            System.out.println("元素 " + target + " 不在数组中");
        } else {
            System.out.println("元素 " + target + " 在数组中的索引是: " + result);
        }
    }
}
