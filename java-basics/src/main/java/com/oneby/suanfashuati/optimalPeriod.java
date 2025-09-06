package com.oneby.suanfashuati;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class optimalPeriod {
    public static void main(String[] args) {
    /**
     * 方法思路
     * 要找到满足平均失败率小于等于给定容忍值的最长时间段，可以采用滑动窗口的方法。滑动窗口技术能够有效地遍历所有可能的时间段，并检查这些时间段的平均失败率是否符合要求。具体步骤如下：
     *
     * 1.初始化指针和结果集：使用两个指针left和right来表示当前窗口的左右边界，初始时都指向数组的起始位置。同时，维护一个结果列表来存储所有满足条件的最长时间段。
     *
     * 2.滑动窗口扩展：移动right指针扩展窗口的右边界，计算当前窗口内的平均失败率。
     *
     * 3.检查条件：如果当前窗口的平均失败率小于等于容忍值，则记录当前窗口的起始和结束位置。如果当前窗口的长度大于之前记录的最长长度，则更新结果列表；如果等于最长长度，则将当前窗口加入结果列表。
     *
     * 4.滑动窗口收缩：如果当前窗口的平均失败率超过容忍值，则移动left指针收缩窗口的左边界，直到窗口内的平均失败率再次满足条件。
     *
     * 5.输出结果：遍历结束后，输出所有满足条件的最长时间段的起始和结束下标。
     */
        Scanner scanner = new Scanner(System.in);
        int minAverageLost = Integer.parseInt(scanner.nextLine());
        String[] parts = scanner.nextLine().split(" ");
        int[] failureRates = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            failureRates[i] = Integer.parseInt(parts[i]);
        }

        List<String> result = findLongestPeriods(failureRates, minAverageLost);
        if (result.isEmpty()) {
            System.out.println("NULL");
        } else {
            System.out.println(String.join(" ", result));
        }
    }

    public static List<String> findLongestPeriods(int[] failureRates, int minAverageLost) {
        List<String> result = new ArrayList<>();
        int maxLength = 0;
        int n = failureRates.length;

        for (int left = 0; left < n; left++) {
            int sum = 0;
            // 滑动窗口right永远在left的右侧
            for (int right = left; right < n; right++) {
                sum += failureRates[right];
                int currentLength = right - left + 1;
                double average = (double) sum / currentLength;
                if (average <= minAverageLost) {
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        //有更长的时间段的时候，清楚之前的result
                        result.clear();
                        result.add(left + "-" + right);
                    } else if (currentLength == maxLength) {
                        result.add(left + "-" + right);
                    }
                }
            }
        }

        return result;
    }

}
