package com.oneby.suanfashuati;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class DeZhouPuKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nums = new String[5];
        String[] colors = new String[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = sc.next();
            colors[i] = sc.next();
        }

        System.out.println(getResult(nums, colors));
    }

    public static int getResult(String[] nums, String[] colors) {
        Arrays.sort(nums, (a, b) -> cards(a) - cards(b));

        if (isShunzi(nums) && isTonghua(colors)) return 1;
        else if (isSitiao(nums)) return 2;
        else if (isHulu(nums)) return 3;
        else if (isTonghua(colors)) return 4;
        else if (isShunzi(nums)) return 5;
        else if (isSantiao(nums)) return 6;
        else return 0;
    }

    // 牌大小 映射为 数值
    public static int cards(String num) {
        switch (num) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(num);
        }
    }

    // 顺子
    public static boolean isShunzi(String[] nums) {
        if ("2345A".equals(String.join("", nums))) return true;

        for (int i = 1; i < nums.length; i++) {
            int num1 = cards(nums[i - 1]);
            int num2 = cards(nums[i]);
            if (num1 + 1 != num2) return false;
        }

        return true;
    }

    // 同花
    public static boolean isTonghua(String[] colors) {
        // 同花牌的所有花色都一样
        return new HashSet<String>(Arrays.asList(colors)).size() == 1;
    }

    // 四条
    public static boolean isSitiao(String[] nums) {
        // 四条由两部分组成，一个部分四张相同牌，一个部分一张牌
        return countNums(nums, 2, 4);
    }

    // 葫芦
    public static boolean isHulu(String[] nums) {
        // 葫芦由两部分组成，一个部分三张牌相同，一个部分两张牌相同
        return countNums(nums, 2, 3);
    }

    // 三条
    public static boolean isSantiao(String[] nums) {
        // 三条由三部分组成，第一个部分由三张相同牌组成，第二个，第三个部分分别是两种不同的牌
        return countNums(nums, 3, 3);
    }

    private static boolean countNums(String[] nums, int partCount, int maxSameNumCount) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        if (count.keySet().size() != partCount) return false;

        return count.containsValue(maxSameNumCount);
    }
}
