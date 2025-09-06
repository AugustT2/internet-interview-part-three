package com.oneby.suanfashuati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ModeMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] nums =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(nums));
    }

    public static int getResult(Integer[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        // 统计各数字出现次数
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 获取最大出现次数
        int max = count.values().stream().max((a, b) -> a - b).orElse(0);

        // 将众数挑选出来
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer k : count.keySet()) {
            if (count.get(k) == max) ans.add(k);
        }

        // 众数升序
        ans.sort((a, b) -> a - b);

        // 中位数取值
        int mid = ans.size() / 2;
        if (ans.size() % 2 == 0) {
            // 偶数个数时，取中间两个位置的平均值
            return (ans.get(mid) + ans.get(mid - 1)) / 2;
        } else {
            // 奇数个数时，取中间位置的值
            return ans.get(mid);
        }
    }
}
