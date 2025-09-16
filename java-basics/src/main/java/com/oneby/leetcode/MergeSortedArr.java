package com.oneby.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 我们注意到数组的有序性，可以使用双指针的方法，从后向前遍历两个数组，每次取两个数组中较大的一个放进合并后的数组的最后面。
 */
public class MergeSortedArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num1 = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int m = num1.length;
        int n = num2.length;
        merge(num1, num2, m, n);
    }

    private static void merge(int[] num1, int[] num2, int m, int n) {
        for(int i = m-1, j = n-1, k = m + n -1; j >= 0; --k) {
            num1[k] = i >= 0 && num1[i] > num2[j] ? num1[i--] : num2[j--];
        }
    }
}
